<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/threeminutessul/userjoin.tmssul" method="post">
		ID : <input type="text" id="userid" name="userid" /> <br />
		PW : <input type="password" id="userpw" name="userpw" /><br />
		닉네임 : <input type="text" id="nickname" name="nickname" /><br />
		프로필사진 : <input type="text" id="profile" name="profile"/><br />
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>