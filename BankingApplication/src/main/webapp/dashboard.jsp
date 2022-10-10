<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
html {
  box-sizing: border-box;
}
*, *:before, *:after {
  box-sizing: inherit;
}
.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}
@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}
.container {
  padding: 0 16px;
}
.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}
.title {
  color: grey;
}
.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  border-radius:15px;
}
.button1 {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 5px 20px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 5%;
  border-radius:15px;
}
.button:hover {
  background-color: #555;
}
p {
  margin-top:1em;
  text-align:right;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}
li {
  display: inline;
}
</style>
</head>
<body>

<ul>
  <li style="font-size:40px;text-align:center;font-weight:bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Services&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li><a href="home.jsp" class="button1">Logout</a></li>
</ul>	
<br>
<div class="row">
  <div class="column">
    <div class="card">
         <a href="accdetails.jsp"><img src="images/accdetails.webp" alt="Account Details" width="594" height="300"></a>
      <div class="container">
        <a href="accdetails.jsp" class="button">Account Overview</a>       
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <a href="withdraw.jsp"><img src="images/withdraw.jpg" alt="Withdraw" width="594" height="300"></a>
      <div class="container">
      <a href="withdraw.jsp" class="button">Withdraw</a>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <a href="deposit.jsp"><img src="images/deposit.jpeg" alt="Deposit" width="594" height="300"></a>
      <div class="container">
        <a href="deposit.jsp" class="button">Deposit</a>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <a href="transfer.jsp"><img src="images/transfer.jpg" alt="Transfer" width="594" height="300"></a>
      <div class="container">
        <a href="transfer.jsp" class="button">Transfer</a>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <a href="update.jsp"><img src="images/update.jpeg" alt="Update" width="594" height="300"></a>
      <div class="container">
        <a href="update.jsp" class="button">Update</a>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <a href="Transaction"><img src="images/transaction.avif" alt="Transaction" width="594" height="300"></a>
      <div class="container">
        <a href="Transaction" class="button">Transaction History</a>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <a href="mobileRecharge.jsp"><img src="images/mobilerecharge.jpeg" alt="Mobile Recharge" width="594" height="300"></a>
      <div class="container">
        <a href="mobileRecharge.jsp" class="button">Mobile Recharge</a>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <a href="delete.jsp"><img src="images/delete.jpeg" alt="Close Account" width="594" height="300"></a>
      <div class="container">
        <a href="delete.jsp" class="button">Close Account</a>
      </div>
    </div>
  </div>
</div>
</body>
</html>
