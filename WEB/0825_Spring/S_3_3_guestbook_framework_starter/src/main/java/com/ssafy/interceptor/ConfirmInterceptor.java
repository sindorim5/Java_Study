package com.ssafy.interceptor;

import javax.servlet.http.*;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.guestbook.model.MemberDto;

public class ConfirmInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
        if(memberDto == null) {
            response.sendRedirect(request.getContextPath());
            return false;
        }
        return true;
    }

    
    
}
