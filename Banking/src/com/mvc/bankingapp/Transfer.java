package com.mvc.bankingapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("acc_no");
		
		String racn = request.getParameter("racn");
		String amt = request.getParameter("amt");
		
		int theRacn = Integer.parseInt(racn);
		int theAmt = Integer.parseInt(amt);
		
		
		
		Model model = new Model();
		
		model.setAcc_no(accno);
		model.setBalance(theAmt);
		model.setRacn(theRacn);
		
		
		
		boolean result = model.transfer();
		
		if(result == true)
		{
			session.setAttribute("amt", theAmt);
			session.setAttribute("racn", theRacn);
			
			response.sendRedirect("/Banking/successTransfer.jsp");
		}
		else
			response.sendRedirect("/Banking/transferFail.html");
		
		
	}
}
