<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>
<%
	Map<String, Object> map = (HashMap)session.getAttribute("param1");
	if(map!=null){
		System.out.println("post하러옴. map null아님.");
		System.out.println(map.get("redirect_uri"));
	}
%>
<form id="frm" name="frm" action="https://accounts.google.com/o/oauth2/token" method="POST" enctype="application/x-www-form-urlencoded">
	<input type="hidden" id="code" name="code" value=<%=map.get("code") %>>
	<input type="hidden" id="client_id" name="client_id" value=<%=map.get("client_id") %>>
	<input type="hidden" id="client_secret" name="client_secret" value=<%=map.get("client_secret") %>>
	<input type="hidden" id="redirect_uri" name="redirect_uri" value=<%=map.get("redirect_uri") %>>
	<input type="hidden" id="grant_type" name="grant_type" value=<%=map.get("grant_type") %>>
	<input type="submit" value="이상하네">
</form>


</body>
</html>