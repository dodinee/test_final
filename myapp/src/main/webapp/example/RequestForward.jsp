<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zerock.myapp.Person"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4>reqestMain attribute</h4>

<% Person pPerson = (Person)request.getAttribute("requestPerson"); %>
</body>
</html>