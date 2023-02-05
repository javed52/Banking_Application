package com.mvc.bankingapp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	{
		String custid = request.getParameter("custid");
		String pwd = request.getParameter("pwd");
		
		Model model = new Model();
		model.setCust_id(custid);
		model.setPwd(pwd);
		
		boolean result = model.login();
		if(result == true)
		{
			int acc_no = model.getAcc_no();
			String name = model.getName();
			int balance = model.getBalance();
			
			
			HttpSession session = request.getSession(true);
			session.setAttribute("acc_no", acc_no);
			session.setAttribute("name", name);
			session.setAttribute("balance", balance);
			try
			{
				response.sendRedirect("/Banking/home.jsp");
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
				response.sendRedirect("/Banking/errorLogin.html");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
}
