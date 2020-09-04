<%@page import="domain.Token"%>
<%@page import="domain.VO.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//ModelAndView도 내부적으로 setAttribute로 알고있었는데 아니네
		//UserVO uservo = (UserVO)session.getAttribute("uservo2");
		//String code = uservo.getUserCode();
		Token token = (Token)session.getAttribute("token");
		String access_token = token.getAccess_token();
		String refresh_token = token.getRefresh_token();
	%>
	<%=access_token %><br>
	<%=refresh_token %><br>
	<!-- ${uservo.getUserCode()} -->
</body>
</html>