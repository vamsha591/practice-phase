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
		<h1 style="color: green" >${msg}</h1>
		<form:form action="saveTeacher" modelAttribute="teacher">
		
			<input name="name">
			<input name="email">
			<button>Save</button>
		
		</form:form>
		
		<a href="getAllData">Display The Teacher</a>
</body>
</html>