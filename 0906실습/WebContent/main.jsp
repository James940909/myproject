<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.member.*"%>
<jsp:useBean id="memberDAO" class="model.member.MemberDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<form action="control.jsp" method="post" name="form1">
	<input type="hidden" name="action" value="login">
	<table border="1">
		<h2>~~~4조참치~~~</h2>
		<hr>
		<th>로그인</th>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan='2' align="right"><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>
<hr>
<a href="signUp.jsp">회원가입 하러가기</a>
<hr>

</body>
</html>