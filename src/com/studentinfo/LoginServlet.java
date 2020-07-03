package com.studentinfo;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    	   static Logger logger = Logger.getLogger(LoginServlet.class);
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		}
	 {
		// TODO Auto-generated method stub
		//return null;
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("user");
		String Password=request.getParameter("pass");
		System.out.println("hello " + userName);
		HttpSession session=request.getSession();
		//boolean flag=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smdb","root","Jayalaxmi");
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from smdb.studentinfo where User_Name=" + "'" + userName + "'");
			while(rs.next())
			{
				if(userName.equals(rs.getString(3)) && (Password.contentEquals(rs.getString(4)))   )
				{
					PreparedStatement ps=con.prepareStatement("select First_Name,Last_Name from smdb.studentinfo where User_Name=" + "'" + userName + "'");
					ResultSet rSet=ps.executeQuery();
					while(rSet.next())
					{
						String firstName=rs.getString(1);
						String lastName=rs.getString(2);
						System.out.println("HELLO " +firstName );
						session.setAttribute("fName", firstName);
						session.setAttribute("lName", lastName);
						  RequestDispatcher rd=request.getRequestDispatcher("/welcome.jsp");  
					        rd.forward(request, response); 
					}
				}
				else
				{
					out.println("Check your username or password");
				}
			}

			
		} catch (ClassNotFoundException p) {
			
			out.print(p);
			p.printStackTrace();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	
	
	
	
	//PrintWriter out=response.getWriter();
	//HttpSession session=request.getSession();
	//Connection con=getConnection();
	
	}

