package com.mvc.bankingapp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ChangePasswordFilter
 */
public class ChangePasswordFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String npwd = request.getParameter("npwd");
		String cnpwd = request.getParameter("cnpwd");
		if(npwd.equals(cnpwd))
			chain.doFilter(request, response);
		else
			((HttpServletResponse) response).sendRedirect("/Banking/errorChangePassword.jsp");
	}

}
