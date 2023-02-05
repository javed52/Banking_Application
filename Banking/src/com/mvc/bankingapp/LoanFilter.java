package com.mvc.bankingapp;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoanFilter
 */
public class LoanFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoanFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		String lamt  = request.getParameter("amt");
		String salary = request.getParameter("salary");
		int theLamt = Integer.parseInt(lamt);
		int theSalary = Integer.parseInt(salary);
		if(theLamt>theSalary)
		{
			((HttpServletResponse) response).sendRedirect("/Banking/errorLoan.jsp");
		}
		else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
