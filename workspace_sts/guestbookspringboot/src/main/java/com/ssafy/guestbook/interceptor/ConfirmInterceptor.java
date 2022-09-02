package com.ssafy.guestbook.interceptor;

import javax.servlet.http.*;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.guestbook.model.MemberDto;

@Component
public class ConfirmInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
        if(memberDto == null) {
            if(request.getContextPath().equals("")) {
                response.sendRedirect("/");
            }else {
                response.sendRedirect(request.getContextPath());
            }
            return false;
        }
        return true;
    }

    
    
}
