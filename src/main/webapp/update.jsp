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
		<form:form  action="updateTeacher" modelAttribute="editTeacher">
		
			<form:input path="id" readonly="true"/>
			<form:input path="name"/>
			<form:input path="email"/>
			<form:button>Update</form:button>
		</form:form>
</body>
</html>