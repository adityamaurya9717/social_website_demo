package com.management.intercepter;

import com.management.proxy.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(value=Ordered.LOWEST_PRECEDENCE)
public class FirstFilter implements Filter {
    @Autowired
    UserComponent userComponent;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String userId = httpServletRequest.getParameter("userId");
        userComponent.getCurrentUser().setUserId(userId);
        chain.doFilter(request,response);

    }
}
