package com.javaWebExam.filter;

import com.javaWebExam.entities.user.Role;
import com.javaWebExam.entities.user.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//TODO filter correct uri
@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) req).getSession();
        User user = (User) session.getAttribute("currentUser");
        if (user==null || user.getRole() != Role.ADMIN) {
            ((HttpServletResponse) resp).sendRedirect("/");
            return;
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
