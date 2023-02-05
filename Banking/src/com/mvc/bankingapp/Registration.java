package com.mvc.bankingapp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("name");
		int acno = Integer.parseInt(request.getParameter("acno"));
		int balance = Integer.parseInt(request.getParameter("balance"));
		String cid = request.getParameter("cid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		Model model = new Model();
		model.setName(name);
		model.setAcc_no(acno);
		model.setBalance(balance);
		model.setCust_id(cid);
		model.setPwd(pwd);
		model.setEmail(email);
		
		boolean result = model.register();
		if(result == true)
		{
			try
			{
				response.sendRedirect("/Banking/registerSuccess.jsp");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{

			try
			{
				response.sendRedirect("/Banking/registerUnSuccess.html");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		
		
	}
}
