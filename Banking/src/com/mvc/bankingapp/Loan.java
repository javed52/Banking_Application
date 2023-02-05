package com.mvc.bankingapp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Loan
 */
public class Loan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	{
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String yr = request.getParameter("year");
		String gender = request.getParameter("g1");
		String occupation = request.getParameter("j1");

		
		HttpSession session = request.getSession();
		int acc_no = (int) session.getAttribute("acc_no");
		
		String lamt  = request.getParameter("amt");
		String salary = request.getParameter("salary");
		int theLamt = Integer.parseInt(lamt);
		int theSalary = Integer.parseInt(salary);
		int year = Integer.parseInt(yr);
		
		Model model = new Model();
		model.setAcc_no(acc_no);
		model.setFname(fname);
		model.setLname(lname);
		model.setLoan_amt(theLamt);
		model.setSalary(theSalary);
		model.setYear(year);
		model.setGender(gender);
		model.setOccupation(occupation);
		
		boolean result = model.loan();
		if(result == true)
			try
			{
				response.sendRedirect("/Banking/success.jsp");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		else
			try 
			{
				response.sendRedirect("/Banking/errorInLoanSanction.html");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		
	}

}
