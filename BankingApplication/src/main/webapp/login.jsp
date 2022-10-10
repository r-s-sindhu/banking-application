<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
  background-image: url('images/login.avif');
  background-repeat: no-repeat;
  background-size: cover;
  background-color: white;
  width: 450px;
  border: 4px solid black;
  padding: 50px;
  margin: 200px 650px;
}
.button {
  background-color: #00008B;
  border: none;
  color: white;
  padding: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
}
.button1 {border-radius: 10px;}
</style>
<title>Login Page</title>
</head>
<body>
<form action="Login" method="post">
<center>
	<h1 style="color:black">Login Page</h1>
	<br><br>
	<p style="color:black;font-size:20px">
		Enter Username<span style="color:red">*</span> : <input type="text" name="luser" required="required" style="font-size:20px"><br><br>
		Enter Password<span style="color:red">*</span> : <input type="password" name="lpwd" required="required" style="font-size:20px"><br><br>

				<!-- <input type="submit" value="Login" style="font-size:20px"><br><br> -->
				<button class="button button1">Login</button><br>
				<a href="register.jsp">Signup here</a><br><br>
				<a href="home.jsp">Home Page</a>
	</p>
</center>
</form>
</body>
</html>