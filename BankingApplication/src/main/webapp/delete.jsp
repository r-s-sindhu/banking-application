<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
  background-image: url('images/1.jpg');
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
.button1 {border-radius: 15px;}
</style>

<title>Delete Account</title>
</head>
<body>
<center>
	<h1 style="color:blue;font-size:30px">Close Account</h1>
	<form action="Delete"><br><br>
	<p style="font-size:20px">
		Enter Username<span style="color:red">*</span> : <input type="text" name="username" required="required" style="font-size:20px"><br><br>
		Enter Password<span style="color:red">*</span> : <input type="password" name="pwd" required="required" style="font-size:20px"><br><br>
		<!-- <input type="submit" value="submit" style="font-size:20px"> -->
		<button class="button button1">Submit</button><br> 
	</p>
	<a href="dashboard.jsp" style="font-size:20px">Go Back</a>
	</form>
</center>
</body>
</html>