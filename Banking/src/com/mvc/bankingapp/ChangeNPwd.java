package com.mvc.bankingapp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeNPwd
 */
public class ChangeNPwd extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		String npwd = request.getParameter("npwd");
		
		Model model = new Model();
		model.setEmail(email);
		model.setPwd(npwd);
		
		boolean result = model.forgetPwd();
		if(result == true)
		{
			try
			{
				response.sendRedirect("/Banking/success.html");
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
				response.sendRedirect("/Banking/fail.html");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
}
