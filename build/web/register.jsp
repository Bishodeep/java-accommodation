<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accommodation Portal</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
 <div class="container">
  <div class="card" style="margin-top: 50px;">
   <div class="card-body">
   <h4 style="text-align: center;">Register</h4>
<form action="register"  method="post">
	<div class="form-group row">
      <label for="firstName" class="col-sm-2 col-form-label">
       Student Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="studentname"
        placeholder="Enter student name">
      </div>
     </div>

     <div class="form-group row">
      <label for="StudentAge" class="col-sm-2 col-form-label">
       Student Age</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="age"
        placeholder="Enter age">
      </div>
     </div>
     <div class="form-group row">
      <label for="address" class="col-sm-2 col-form-label">Address
       </label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="address"
        placeholder="Enter address">
      </div>
     </div>

     <div class="form-group row">
      <label for="contact" class="col-sm-2 col-form-label">Contact</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="contact"
        placeholder="Enter contact">
      </div>
     </div>
     <div class="form-group row">
      <label for="user name" class="col-sm-2 col-form-label">Use Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="username"
        placeholder="Enter user name">
      </div>
     </div>
     <div class="form-group row">
      <label for="password" class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-7">
       <input type="password" class="form-control" name="password"
        placeholder="Enter password">
      </div>
     </div>
     <button type="submit" class="btn btn-primary" style="align-items: center;">Register</button>
     <p>${error}</p>
     </form>
     </div>
     </div>
     </div>
</body>
</html>