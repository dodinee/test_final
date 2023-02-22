<%@ page import="com.zerock.myapp.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
request.setAttribute("requestString", "request영역의 문자열");
request.setAttribute("requestPerson", new Person("이소진", 123));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>

<body>
	<h2>request attribute</h2>

	<%
        request.removeAttribute("requestString");
        request.removeAttribute("requestInteger");
    %>

	<h2>request attribute</h2>

	<% Person rPerson = (Person)(request.getAttribute("requestPerson")); %>

	<ul>
		<li>String : <%= request.getAttribute("requestString") %></li>
		<li>Person : <%= rPerson.getName()%>, <%= rPerson.getAge()%></li>
	</ul>

	<h2>request attribute Forward</h2>
	<% request.getRequestDispatcher("Requestforward.jsp?paramHan=한글&paramEng=English").forward(request, response); %>
</body>

</html>
