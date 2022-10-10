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
<title>Withdraw Form</title>
</head>

<body>
<center>
	<h1 style="font-size:30px;color:blue">Withdraw Form</h1><br>
	<form action="Withdraw"><br>
		<p style="font-size:20px">
			Amount<span style="color:red">*</span>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="number" name="amount" required="required" style="font-size:20px"><br><br>			
			<!-- <input type="submit" value="submit" style="font-size:20px"> -->
			<button class="button button1">Submit</button><br> 
		</p>
		<a href="dashboard.jsp" style="font-size:20px">Go Back</a>
	</form>
</center>
</body>
</html>