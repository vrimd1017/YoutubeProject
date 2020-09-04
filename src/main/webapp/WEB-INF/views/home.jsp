<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.VO.CategoryVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	
	<P>The time on the server is ${serverTime}.</P>
	<hr>
	<div>
		<h3>유튜브 인증을 위해 해당 페이지로 접근합니다.</h3>
		<!-- 인증된 사용자인지를 먼저 확인해야될듯 으 조뗏당 -->
		<h5>아 ...이거 하려면 간단하게 로그인도 구현하긴 해야겟네</h5>
		<form action="login" method="POST">
			<label>id<input type="text" name="userEmail" placeholder="아이디입력"></label>
			<label>password<input type="password" name="userPassword" placeholder="비밀번호입력"></label>
			<input type="submit" value="로그인"/>
		</form>
		
	</div>
	<form action="registUser" method="GET">
		<input type="submit" name="registUser" value="회원가입"/>
	</form>
	<!-- <a
			href="https://accounts.google.com/o/oauth2/auth?client_id=544959004631-rcuitmelmdk664g3cpoquak91b51j92e.apps.googleusercontent.com&redirect_uri=http%3a%2f%2flocalhost%3a8080%2fmyapp%2fAuth&scope=https%3a%2f%2fwww.googleapis.com%2fauth%2fyoutube&response_type=code&access_type=offline"><input
			type="button" name="authlink" value="인증">인증이였는데 누르지 마세요 임시 제한</a>-->
</body>
</html>
