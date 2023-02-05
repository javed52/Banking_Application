package com.mvc.bankingapp;

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

/**
 * Servlet Filter implementation class TransferFilter
 */
public class TransferFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransferFilter() {
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
		HttpSession session = ((HttpServletRequest) request).getSession();
		int balance1 = (int) session.getAttribute("balance");
		
		
		String balance = request.getParameter("amt");
		int amt = Integer.parseInt(balance);
		
		if(amt <= 0)
		{
			((HttpServletResponse) response).sendRedirect("/Banking/errorTransfer.jsp");
		}
		if(amt >= balance1)
		{
			((HttpServletResponse) response).sendRedirect("/Banking/insufficientbalance.jsp");
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
