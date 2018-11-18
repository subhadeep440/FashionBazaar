<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <style type="text/css">
            #upperlable
            {
                background-color: Gray;
            }
        </style>
    </head>
    <body>
    <div id="upperlable" class="container-fluid">
       <p align="right">
            <a href="https://www.facebook.com/"><img src="C:\Users\SUBHADEEP\eclipse-workspace\ProjectFrontend\src\main\webapp\resources\images\fb.ico" width="50" height="50"></a>
              <a href="https://www.gmail.com/"><img src="C:\Users\SUBHADEEP\eclipse-workspace\ProjectFrontend\src\main\webapp\resources\images\g.png" width="50" height="50"></a> 
                
           </p>
        </div>
        
    <div class="container">
        <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="index">FashionBazzar</a>
            </div>
            <c:if test="${!sessionScope.loggedIn}">
            <ul class="nav navbar-nav">
                 
                <li><a href="login">Login</a></li>
                   <li><a href="register">Register</a></li>
                   <li><a href="aboutus">About US</a></li>
                   <li><a href="contactus">Contact US</a></li>
                   
            </ul>
            </c:if>
            <c:if test="${sessionScope.loggedIn}">
            <c:if test="${sessionScope.role=='ROLE_ADMIN' }">
             <ul class="nav navbar-nav">
       
             <li><a href="category">Category</a></li>
             <li><a href="supplier">Supplier</a></li>
             <li><a href="product">Product</a></li>
             </ul>
             </c:if>
             <c:if test="${sessionScope.role=='ROLE_USER' }">
              <ul class="nav navbar-nav">
                
               <li><a href="cart"></a>${cartsize}<span class="glyphicon glyphicon-shopping-cart"></span></li>
              </ul>
             </c:if>
            </c:if>
           
            </div>
            </nav>
            </div>

</body>