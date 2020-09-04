<%@page import="domain.Token"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AuthTest</title>
</head>
<body>
<%
	Token token = (Token)session.getAttribute("token");
%>
<%=token.getAccess_token() %>
</body>
</html>