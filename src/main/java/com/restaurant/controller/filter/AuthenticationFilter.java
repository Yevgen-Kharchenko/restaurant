package com.restaurant.controller.filter;

import com.restaurant.config.SecurityConfig;
import com.restaurant.model.User;
import com.restaurant.model.enums.Role;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(AuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        String path = getPath(httpServletRequest);

        if (!SecurityConfig.isSecurePage(path)) {
            LOG.info("Page is not secured: " + path);
            chain.doFilter(request, response);
            return;
        }
        String contextPath = httpServletRequest.getContextPath();

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            LOG.info("User not logged");
            httpServletResponse.sendRedirect(contextPath + "/login");
            return;

        }

        if (hasNotPermission(path, user.getRole())) {
            LOG.debug("User has not permission : " + user + " , " + path);
            httpServletResponse.sendRedirect(contextPath + "/403-error");
            return;
        }

        LOG.info("User has permission. Continue");
        chain.doFilter(request, response);
    }

    private boolean hasNotPermission(String path, Role role) {
        return !SecurityConfig.hasPermission(path, role);
    }

    private boolean isNotSecuredPage(String path) {
        return !SecurityConfig.isSecurePage(path);
    }

    @Override
    public void destroy() {
    }

    private String getPath(HttpServletRequest req) {
        String requestUri = req.getRequestURI();
        int lastPath = requestUri.lastIndexOf('/');
        String path = requestUri.substring(lastPath);
        LOG.info("Path: " + path);
        return path;
    }
}
