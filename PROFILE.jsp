
<%
String str = (String) session.getAttribute("username");
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
		WELCOME DEAR :- <span style="color: red;"><%=str%></span>
	</h1>
</body>
</html>