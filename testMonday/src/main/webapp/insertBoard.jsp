<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="main.do">메인으로 돌아가기</a>
<form action="insertBoard.do?writer=${name}" method="post">

<table border="1">
	<tr>
		<td>작성자</td>
		<td><input type="text" name="name" value="${name}"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="content"></td>
	</tr>
	<tr>
		<td colspan='2'><input type="submit" value="작성 완료">
	</tr>
</table>

</form>

</body>
</html>