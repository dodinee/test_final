<%@ page import="com.zerock.myapp.Person" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
request.setAttribute("requestString", "request영역의 문자열");
request.setAttribute("requestPerson", new Person("이소진", 123));
%>

<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
