<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <title>Login Page</title>
 <!-- Include Bootstrap CSS -->
 <link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
 <%@ include file="base.jsp" %>
 <div class="container">
 <div class="row justify-content-center mt-5">
 <div class="col-md-4">
 <h2 class="text-center">Login</h2>
 <form id="loginForm">
 <div class="form-group">
 <label for="email">Email:</label>
 <input type="email" class="form-control"id="email" name="email" required>
 </div>
 <div class="form-group">
 <label for="password">Password:</label>
 <input type="password" class="form-control"id="password" name="password" required>
 </div>
 <button type="submit" class="btn btn￾success">Login</button>
 <div id="messageList"></div>
 <p>Register yourself: <ahref="/register">Register</a></p>
 </form>
 </div>
 </div>
 </div>
 <!-- Include JavaScript -->
 <script>
 document.getElementById("loginForm").addEventListener("submit", function (event) {
 event.preventDefault(); // Prevent form submission
 const payload = {
 email: document.getElementById("email").value,
 password: document.getElementById("password").value,
 }
 </script>
 </body>
 </html>