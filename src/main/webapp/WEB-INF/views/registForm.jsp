<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입페이지입니다.</h1>
	<h3>회원가입시 이메일이 송신됩니다. 사용하시는 이메일을 입력해 주세요</h3>
	<div>
		<form action="registUser" method="POST">
			<label>이메일 : <input type="text" name="userEmail" placeholder="사용하시는 이메일을 입력해주세요"></label><br>
			<label>비밀번호:<input type="password" name="userPassword" placeholder="사용하고자 하는 비밀번호를 입력해 주세요"></label><br>
			<input type="submit" value="회원가입"/>
		</form>
	</div>
</body>
</html>