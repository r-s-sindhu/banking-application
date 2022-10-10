<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body {
  background-image: url('images/login.avif');
  background-repeat: no-repeat;
  background-size: cover;
  background-color: white;
  width: 450px;
  border: 4px solid black;
  padding: 50px;
  margin: 50px 650px;
}
.button {
  background-color: #00008B;
  border:none;
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
<title>Register Page</title>
</head>
<body>
<form action="Register" method="post">
<div>
	<center>
		<h1 style="color:black">Sign Up</h1>
		<br>
		<p style="font-size:20px">
		Enter Username<span style="color:red">*</span> : &nbsp;<input type="text" name="user" required="required" style="font-size:20px"><br><br>
		Enter Password<span style="color:red">*</span> : &nbsp;&nbsp;<input type="password" name="pwd" required="required" style="font-size:20px"><br><br>
		Retype Password<span style="color:red">*</span> : <input type="password" name="cpwd" required="required" style="font-size:20px"><br><br>
		
		Select Gender<span style="color:red">*</span> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="gender" value="male" required="required" style="font-size:20px">Male &nbsp;&nbsp;
		<input type="radio" name="gender" value="female" required="required" style="font-size:20px">Female &nbsp;&nbsp;
		<input type="radio" name="gender" value="other" required="required" style="font-size:20px">Other &nbsp;&nbsp;
		<br><br>
		
		Enter Mobile No<span style="color:red">*</span> : <input type="number" name="phno" required="required" style="font-size:20px"><br><br> 
		Address<span style="color:red">*</span> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="add" required="required" style="font-size:20px"><br><br>
		Enter Email<span style="color:red">*</span> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="email" required="required" style="font-size:20px"><br><br>
		Enter Amount<span style="color:red">*</span> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="amt" required="required" style="font-size:20px"><br><br>
		Select Account Type<span style="color:red">*</span> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="acc_type" required="required" style="font-size:20px">
			<option value="" style="font-size:20px">Select account type</option>
			<option value="Savings" style="font-size:20px">Savings</option>
			<option value="Current" style="font-size:20px">Current</option>
		</select><br><br>
		
						<!-- <input type="submit" value="sign up" style="font-size:20px"><br><br> -->
						<button class="button button1">Sign Up</button><br>
						<a href="login.jsp">Login here</a><br><br>
						<a href="home.jsp">Home Page</a>
		</p>
	</center>
</div>
</form>
</body>
</html>