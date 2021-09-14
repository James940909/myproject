<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<form action="control.jsp" method="post" name="form1">
	<input type="hidden" name="action" value="signUp">
	<table border="1">
		<th>회원가입</th>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan='2' align="right"><input type="submit" value="회원가입"></td>
		</tr>
	</table>

</form>
</body>
</html>