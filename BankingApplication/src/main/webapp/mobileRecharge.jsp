<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  width: 500px;
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

<title>Mobile Recharge</title>
</head>
<body>
<form action="MobileRecharge" method="post">
<center>
<h1 style="font-size:30px;color:blue">Mobile Recharge</h1><br><br>
<p style="font-size:20px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mobile No <span style="color:red">*</span> : <input type="tel" name="mob" id="mob" pattern="[0-9]{5} [0-9]{5}" placeholder="xxxxx xxxxx" required="required" style="font-size:20px"><br><br>
Operator <span style="color:red">*</span>&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="operator" required="required" style="font-size:20px">
	<option value="" style="font-size:20px">Select operator</option>
	<option value="Airtel" style="font-size:20px">Airtel</option>
	<option value="Jio" style="font-size:20px">Jio</option>
	</select><br><br>
State <span style="color:red">*</span> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="state" required="required" style="font-size:20px">
	<option value="" style="font-size:20px">Select state</option>
	<option value="Andhra Pradesh" style="font-size:20px">Andhra Pradesh</option>
	<option value="Karnataka" style="font-size:20px">Karnataka</option>
	<option value="Tamil Nadu" style="font-size:20px">Tamil Nadu</option>
	<option value="Telangana" style="font-size:20px">Telangana</option>
	</select><br><br>
	<!-- <input type="submit" value="submit" style="font-size:20px"> -->
	<button class="button button1">Submit</button><br> 
</p>
</center>
</form>
</body>
</html>