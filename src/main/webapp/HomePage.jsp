<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>


</head>
<body>
<form action="" method=post>
<h4>GET DETAILS!...</h4>
<label for="viewDetails">Choose Language:</label>
<select name="language">
  <option value="C">C</option>
  <option value="C++">C++</option>
  <option value="Java">Java</option>
</select><br>
<input type="submit" value="Submit">
</form>

<%
String language = request.getParameter("language");
if(language != null){
%>
<table id="customers">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Phone Number</th>
<th>Email Id</th>
<th>Languages</th>
<tr>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase","root","vardhan");
ResultSet rs=null;


PreparedStatement ps = con.prepareStatement("select  r.FirstName,r.LastName,r.phoneNumber,r.Email,l.language from register r,language l where r.Email = l.Email and l.language = ?");
ps.setString(1, language);
rs = ps.executeQuery();


%>
<%while(rs.next()){ %>
<tr>
<td><%=rs.getString("Firstname")%></td>
<td><%=rs.getString("LastName")%></td>
<td><%=rs.getString("phoneNumber")%></td>
<td><%=rs.getString("Email")%></td>
<td><%=rs.getString("Language")%></td>
</tr>
<%} %>
<%
}
catch(ClassNotFoundException e){
e.printStackTrace();
}

} %>
</table>
</body>
</html>
