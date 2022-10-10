<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">
<style>
body {font-family: "Times New Roman", Georgia, Serif;}
h1, h2, h3, h4, h5, h6 {
  font-family: "Playfair Display";
  letter-spacing: 5px;
}
</style>
</head>
<body>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:2px;font-weight:bold;font-size:30px">
    <a href="#home" class="w3-bar-item w3-button">Banking Application</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
      <a href="#about" class="w3-bar-item w3-button">About</a>
      <a href="login.jsp" class="w3-bar-item w3-button">Login</a>
      <a href="register.jsp" class="w3-bar-item w3-button">Sign up</a>
      <a href="#contact" class="w3-bar-item w3-button">Contact</a>
    </div>
  </div>
</div>

<!-- Header -->
<header class="w3-display-container w3-content w3-wide" style="max-width:1600px;min-width:500px" id="home">
  <img class="w3-image" src="images/home.webp" alt="Bank" width="1600" height="800">
  <div class="w3-display-bottomleft w3-padding-large w3-opacity">
  </div>
</header>
<hr>
<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section -->
  <div class="w3-row w3-padding-64" id="about">
    <div class="w3-col m6 w3-padding-large w3-hide-small">
     <img class="w3-image1" src="images/aboutus.webp" class="w3-round w3-image w3-opacity-min" alt="Table Setting" width="800px" height="200px">
    </div>

    <div class="w3-col m6 w3-padding-large">
      <h1 class="w3-center">About Us</h1><br>
      <p class="w3-large">Online banking allows a user to conduct financial transactions via the Internet. Online banking is also known as Internet banking or web banking.</p>
      <p class="w3-large">Online banking offers customers almost every service traditionally available through a local branch including deposits, transfers, update account details, view account details and close account. Virtually every banking institution has some form of online banking, available both on desktop versions and through mobile apps.</p>
    </div>
  </div>
  
  <hr>
<br><br><br>
  <!-- Contact Section -->
  <div class="w3-container w3-padding-64" id="contact">
    <h1>Contact</h1><br>
      <form action="Contact">
      <p><input class="w3-input w3-padding-16" type="text" placeholder="Name" required name="Name"></p>
      <p><input class="w3-input w3-padding-16" type="email" placeholder="Email" required name="Email"></p>
      <p><input class="w3-input w3-padding-16" type="number" placeholder="Phone" required name="Mobile"></p>
      <p><input class="w3-input w3-padding-16" type="text" placeholder="Message" required name="Message"></p>
      <p><button class="w3-button w3-light-grey w3-section" type="submit">SEND MESSAGE</button></p>
    </form>
  </div>
</div>

<!-- Footer -->
<footer class="w3-center w3-light-grey w3-padding-32">
  
</footer>

</body>
</html>

<!-- https://static.vecteezy.com/system/resources/previews/004/585/326/original/banking-building-business-finance-management-low-poly-wireframe-illustration-isolated-background-free-vector.jpg -->
