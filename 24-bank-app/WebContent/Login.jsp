<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
	<!-- Section: Design Block -->
<section class="text-center">
  <!-- Background image -->
  <div class="p-5 bg-image" style="
        background-image: url('https://mdbootstrap.com/img/new/textures/full/171.jpg');
        height: 300px;
        "></div>
  <!-- Background image -->

  <div class="card mx-4 mx-md-5 shadow-5-strong" style="
        margin-top: -100px;
        background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(30px);
        ">
    <div class="card-body py-5 px-md-5">

      <div class="row d-flex justify-content-center">
        <div class="col-lg-8">
          <h2 class="fw-bold mb-5">Log in now</h2>
    <form action="LoginController" method="POST">
    
    	<div class="form-outline mb-4">
        <select name="loginType" id="loginType" id="form3Example4" class="form-control text-center">
        	<option value="">Select UserType</option>
            <option value="admin">Admin</option>
            <option value="customer">Customer</option>
        </select>
        </div><br><br>
       
        <div class="form-outline mb-4">
        <input type="text" name="firstName" placeholder="Firstname" id="form3Example4" class="form-control text-center">
        </div>
        
        <div class="form-outline mb-4">
        <input type="text" name="lastName" placeholder="Lastname" id="form3Example4" class="form-control text-center">
        </div>
        
        <div class="form-outline mb-4">
        <input type="password" name="password" placeholder="Password" id="form3Example4" class="form-control text-center">
        </div>
        
        <input type="submit" value="Submit" class="btn btn-primary btn-block mb-4">
        <input type="reset" value="Cancel" class="btn btn-danger btn-block mb-4">
        
        <c:if test="${not empty errorMessage}">
            <p style="color: red">${errorMessage}</p>
        </c:if>
    </form>
    </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->
</body>
</html>