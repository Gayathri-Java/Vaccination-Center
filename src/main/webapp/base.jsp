<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String baseUrl = request.getScheme() + "://" + request.getServerName() + 
":" + request.getServerPort() + request.getContextPath();
%>
<br>
<script src="<%= baseUrl %>/script.js"></script>
<input type="hidden" id="baseUrl" value="<%= baseUrl %>"/>
</body>
</html>