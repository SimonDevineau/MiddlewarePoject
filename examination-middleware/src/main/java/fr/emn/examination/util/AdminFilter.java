/**
 * Part of the project : examination fr.emn.examination..util.AdminFiler.java
 * Created
 * by : cedric
 */
package fr.emn.examination.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.emn.examination.model.Role;
import fr.emn.examination.model.User;

/**
 * @author Cedric Nisio
 * 
 */
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {

	HttpServletRequest req = (HttpServletRequest) request;
	HttpSession session = req.getSession();

	User user = (User) session.getAttribute("currentUser");

	if (user != null && user.getRole().equals(Role.ADMINISTRATOR)) {
	    chain.doFilter(request, response);
	}
	else {
	    HttpServletResponse res = (HttpServletResponse) response;
	    res.sendRedirect(req.getContextPath() + "/restrictedArea.xhtml");
	    return;
	}

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }
}
