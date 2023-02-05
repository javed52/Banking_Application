package com.mvc.bankingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model
{
	private String name;
	private int acc_no;
	private int racn;
	private int balance;
	private String cust_id;
	private String pwd;
	private String email;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet res = null;
	
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	public int getAcc_no()
	{
		return acc_no;
	}
	public void setAcc_no(int acc_no) 
	{
		this.acc_no = acc_no;
	}
	
	public int getRacn()
	{
		return racn;
	}
	public void setRacn(int racn)
	{
		this.racn = racn;
	}
	
	
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(int balance) 
	{
		this.balance = balance;
	}
	
	
	public String getCust_id() 
	{
		return cust_id;
	}
	public void setCust_id(String cust_id) 
	{
		this.cust_id = cust_id;
	}
	
	
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}
	
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	Model()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public boolean login()
	{
		try 
		{
			pstmt = conn.prepareStatement("select * from swiss_bank where cust_id = ? and pwd = ?");
			pstmt.setString(1, cust_id);
			pstmt.setString(2, pwd);
			res  = pstmt.executeQuery();
			if(res.next())
			{
				acc_no = res.getInt("ACC_NO");
				name = res.getString("NAME");
				balance = res.getInt("balance");
				return true;
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(res != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(conn != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean checkBalance()
	{
		try
		{
			pstmt = conn.prepareStatement("select * from swiss_bank where acc_no = ?");
			pstmt.setInt(1, acc_no);
			res = pstmt.executeQuery();
			if(res.next())
			{
				balance = res.getInt("balance");
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(res != null)
					res.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	public boolean changePassword()
	{
		try 
		{
			pstmt = conn.prepareStatement("update swiss_bank set pwd = ? where acc_no = ?");
			pstmt.setString(1, pwd);
			pstmt.setInt(2, acc_no);
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			{
				return true;
			}
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean transfer()
	{
		try 
		{
			
			pstmt = conn.prepareStatement("update swiss_bank set balance = balance - ? where acc_no = ?");
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			conn.setAutoCommit(false);
			//For 1st Query PreparedStatement
			int qry1 = pstmt.executeUpdate();
			
			if(qry1 == 1)
			{
				pstmt = conn.prepareStatement("update swiss_bank set balance = balance + ? where acc_no = ?");
				pstmt.setInt(1, balance);
				pstmt.setInt(2, racn);
				//For 2nd Query PreparedStatement
				int qry2 = pstmt.executeUpdate();
				conn.commit();
				if(qry2 == 1)
				{
					pstmt = conn.prepareStatement("insert into statement values(?,?)");
					pstmt.setInt(1, acc_no);
					pstmt.setInt(2, (balance * - 1));
					//For 3rd Query PreparedStatement
					int qry3 = pstmt.executeUpdate();
					
					if(qry3 == 1)
					{
						pstmt = conn.prepareStatement("insert into statement values(?,?)");
						pstmt.setInt(1, racn);
						pstmt.setInt(2, balance);
						//For 4th Query PreparedStatement
						int qry4 = pstmt.executeUpdate();
					
						if(qry4 == 1)
							return true;
					}
				}
				
					
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
		
	}
	
	private  String fname;
	private  String lname;
	private  int loan_amt;
	private int year;
	private  String gender;
	private int salary;
	private String occupation;
	
	
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getLoan_amt() {
		return loan_amt;
	}
	public void setLoan_amt(int loan_amt) {
		this.loan_amt = loan_amt;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
	public boolean loan()
	{
		try 
		{
			pstmt = conn.prepareStatement("insert into loan_table(fname,lname,loan_amt,acc_no,year,salary,gender,occupation) values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setInt(3, loan_amt);
			pstmt.setInt(4, acc_no);
			pstmt.setInt(5, year);
			pstmt.setInt(6, salary);
			pstmt.setString(7, gender);
			pstmt.setString(8, occupation);
			res = pstmt.executeQuery();
			if(res != null)
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;

	}
	//===============================================================================================================================
	//Data type
	private ArrayList<Integer> arrayList;
	public ArrayList<Integer> getArrayList() {
		return arrayList;
	}
	public void setArrayList(ArrayList<Integer> arrayList) {
		this.arrayList = arrayList;
	}
	
	
	
	
	
	public void getStatement() 
	{
		try 
		{
			pstmt  = conn.prepareStatement("select * from STATEMENT where ACC_NO = ?");
			pstmt.setInt(1, acc_no);
			res = pstmt.executeQuery();
			arrayList = new ArrayList<Integer>();
			while(res.next())
			{
				arrayList.add(res.getInt("AMOUNT"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(res != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(conn != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}

	}
	
	
	
	
	public boolean register()
	{
		try 
		{
			pstmt = conn.prepareStatement("insert into swiss_bank values(?,?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setInt(2, acc_no);
			pstmt.setInt(3, balance);
			pstmt.setString(4, cust_id);
			pstmt.setString(5, pwd);
			pstmt.setString(6, email);
			
			int result = pstmt.executeUpdate();
			if(result == 1)
			{
				return true;
			}
		
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean forgetPwd()
	{
		try 
		{
			pstmt = conn.prepareStatement("update swiss_bank set pwd = ? where email = ?");
			pstmt.setString(1, pwd);
			pstmt.setString(2, email);
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			{
				return true;
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
}
