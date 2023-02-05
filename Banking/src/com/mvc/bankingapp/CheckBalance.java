package com.mvc.bankingapp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckBalance
 */
public class CheckBalance extends HttpServlet
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest request,HttpServletResponse response)
{
	HttpSession session = request.getSession();
	int acc_no = (int)session.getAttribute("acc_no");
	
	Model model = new Model();
	model.setAcc_no(acc_no);
	
	boolean result = model.checkBalance();
	if(result == true)
	{
		int balance = model.getBalance();
		session.setAttribute("balance", balance);
		try
		{
			response.sendRedirect("/Banking/checkBalanceSuccess.jsp");
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
			response.sendRedirect("/Banking/checkBalanceError.html");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}

}
