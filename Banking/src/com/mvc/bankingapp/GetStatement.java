package com.mvc.bankingapp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetStatement
 */
public class GetStatement extends HttpServlet
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
		
		Model model = new Model();
		model.setAcc_no(accno);
		model.getStatement();
		
		ArrayList<Integer> arrayList = model.getArrayList();
		
		if(arrayList.isEmpty())
		{
			response.sendRedirect("/Banking/getStatementFail.html");
		}
		else
		{
			session.setAttribute("arrayList", arrayList);
			response.sendRedirect("/Banking/getStatementSuccess.jsp");
		}
		
	}

}