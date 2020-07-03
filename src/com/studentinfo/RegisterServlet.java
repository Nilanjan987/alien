package com.studentinfo;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("HEllo");
		
		String First_Name=request.getParameter("First_Name");
		String Last_Name=request.getParameter("Last_Name");
		String User_Name=request.getParameter("User_Name");
		String Password=request.getParameter("Password");
		String Email=request.getParameter("Email");
		String Confirm_Email=request.getParameter("Confirm_Email");
		String Date_Of_Birth=request.getParameter("Date_Of_Birth");
		Member studentinfo=new Member(First_Name,Last_Name,User_Name,Password,Email,Confirm_Email,Date_Of_Birth);
		RegisterDemo rDemo=new RegisterDemo();
		String result=rDemo.insert(studentinfo);
		response.getWriter().print(result);
	}

}
