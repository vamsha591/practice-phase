<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<form class="form" action="LoginCheck" method="post">
<div class="title">Welcome</div>
      <div class="subtitle">Let's Register!</div>
      <div class="input-container ic1">
        <input id="firstname" class="input" type="text" name="uname" placeholder=" " />
        <div class="cut"></div>
        <label for="firstname" class="placeholder">Name</label>
      </div>
      
      <div class="input-container ic2">
        <input id="email" class="input" type="password" name="pass" placeholder=" " />
        <div class="cut cut-short"></div>
        <label for="email" class="placeholder">Password</>
      </div>
      <button type="text" class="submit" name="register">Register</button>
</form>
</body>
</html>