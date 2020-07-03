package com.studentinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UsernameCheck
 */
@WebServlet("/UsernameCheck")
public class UsernameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsernameCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String userid = request.getParameter("user");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smdb", "root", "Jayalaxmi");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select count(*) as total from smdb.studentinfo where User_Name=" + "'" + userid + "'");
			int count = 0;
			String responseText = null;
			response.setContentType("text/html");

			while (rs.next()) {
				count = rs.getInt("total");

			}

			if (count == 1) {
				System.out.println("Good to go");
			} else {

				responseText = "Wrong username";
			}
			response.getWriter().write(responseText);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		out.println("hi " + userName);
		HttpSession session = request.getSession();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smdb", "root", "Jayalaxmi");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from smdb.studentinfo where User_Name=" + "'" + userName + "'");
			while (rs.next()) {
				if (userName.equals(rs.getString(3))) {

				} else {
					out.print("Username is not present in the database");
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
}
