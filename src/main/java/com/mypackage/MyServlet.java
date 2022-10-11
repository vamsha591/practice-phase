package com.mypackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		String firstName=req.getParameter("fName");
		String lastName=req.getParameter("lName");
		String emailId=req.getParameter("email");
		String phoneNo=req.getParameter("phno");
		String lang[]=req.getParameterValues("lang");
		int i;
		int flag=0;
		ResultSet rs;
		String insertQuery1="insert into register values(?,?,?,?)";
		String insertQuery2="insert into  language values(?,?)";
		String selectQuery="select * from register where Email=? or phoneNumber=?";
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase","root","vardhan");
			PreparedStatement stmt3=con.prepareStatement(selectQuery);
			stmt3.setString(2, phoneNo);
			stmt3.setString(1, emailId);
			rs=stmt3.executeQuery();
			if(!rs.next()) {
				PreparedStatement stmt1=con.prepareStatement(insertQuery1);
				stmt1.setString(1, firstName);
				stmt1.setString(2, lastName);
				stmt1.setString(3, phoneNo);
				stmt1.setString(4, emailId);
				i=stmt1.executeUpdate();
				if(i!=0)
				{
					for(int j=0;j<lang.length;j++)
					{
						PreparedStatement stmt2=con.prepareStatement(insertQuery2);
						stmt2.setString(1, emailId);
						stmt2.setString(2, lang[j]);
						stmt2.executeUpdate();
				}
					flag=1;
			}
			}
			if(flag==0) {
			
				res.sendRedirect("Register.jsp");
			}
			else
			{
				
				res.sendRedirect("HomePage.jsp");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
