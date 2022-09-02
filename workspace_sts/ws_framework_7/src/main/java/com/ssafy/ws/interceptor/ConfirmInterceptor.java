package com.ssafy.ws.interceptor;

import javax.servlet.http.*;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.ws.dto.User;

public class ConfirmInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userinfo");
        if(user == null) {
            response.sendRedirect(request.getContextPath());
            return false;
        }
        return true;
    }

    
    
}
