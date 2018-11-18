
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 80%;
    opacity: 0.9;
}
button:hover {
    opacity:1;
}
/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}
/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}
/* Add padding to container elements */
.container {
    padding: 16px;
    background-color:#aed6f1;
     
}
/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
    padding-left:400px;
}
/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>


</head>
<body>
<%@ include file="Header.jsp"%>
<br>
<div>
<form action="registerUser" method="post" modelAttribute="UserDetail" style="border:1px solid #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account</p>
    <hr>

    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

     <label for="CustomerName"><b>Customer Name</b></label>
     <input type="text" placeholder="Enter your name" name="CustomerName" required>
     
     <label for="emailId"><b>EmailId</b></label>
     <input type="text" placeholder="Enter your emailId" name="emailId" required>
     
     <label for="mobileNo"><b>MobileNo</b></label>
     <input type="text" placeholder="Enter your mobileNo" name="mobileNo" required>
     
    <label for="address"><b>Address</b></label>
     <input type="text" placeholder="Enter your address" name="address" required>
     
          
     <div class="clearfix">
  <input type="submit" value="INSERT">
    </div>
  </div>
</form>

<p><b>Click To Change Password & Other Details</b><a href="UpdateUser">Click</a></p>

</div>
</body>
</html>