package com.mvc.bankingapp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		int acc_no = (int) session.getAttribute("acc_no");
		
		String pwd = request.getParameter("npwd");
		
		
		Model model = new Model();
		model.setAcc_no(acc_no);
		model.setPwd(pwd);
		
		
		boolean result = model.changePassword();
		
		if(result == true)
		{
			try 
			{
				response.sendRedirect("/Banking/changePasswordSuccess.html");
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
				response.sendRedirect("/Banking/changePasswordFail.html");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		
	}

}
