<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<table>
			<tr>
				<th>id</th>
				<th>email</th>
				<th>name</th>
				<th>delete</th>
				<th>edit</th>
				
			</tr>
			<c:forEach var="teacher" items="${getTeacher}">
			
			
				<tr>
					<td>${teacher.getId()}</td>
					<td>${teacher.getName()}</td>
					<td>${teacher.getEmail()}</td>
					<td><button><a href="deleteData?id=${teacher.getId()}">Delete</a></butto></td>
					<td><button><a href="editTeacher1?id=${teacher.getId()}">Update</a></butto></td>
				</tr>
				
			</c:forEach>
		</table>
		
</body>
</html>