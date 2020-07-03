package com.studentinfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterDemo {

		private String dburl="jdbc:mysql://localhost:3306/smdb" ;
		private String dbuname="root";
		private String dbpassword="Jayalaxmi";
		private String dbdriver="com.mysql.jdbc.Driver";
		public void loadDriver(String dbDriver)
		{
			try {  
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Connection getConnection()
		{
			Connection con=null;
			try {
				
				con=DriverManager.getConnection(dburl, dbuname, dbpassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
public String insert(Member studentinfo)
{
	loadDriver(dbdriver);
	Connection con=getConnection();
	
	String message=null;
	try {
		System.out.print(con);
		PreparedStatement ps=con.prepareStatement("insert into smdb.studentinfo values(?,?,?,?,?,?,?)");
		message="Data entered successfully";
		ps.setString(1, studentinfo.getFirst_Name());
		ps.setString(2, studentinfo.getLast_Name());
		ps.setString(3, studentinfo.getUser_Name());
		ps.setString(4, studentinfo.getPassword());
		ps.setString(5, studentinfo.getEmail());
		ps.setString(6, studentinfo.getConfirm_Email());
		ps.setString(7, studentinfo.getDate_Of_Birth());
		ps.executeUpdate();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		message="Data not entered";
	}
	return message;
}
		
}
