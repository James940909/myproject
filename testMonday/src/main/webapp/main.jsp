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

<hr>
<h1>글 목록</h1>
<hr>
<table border="1">
	<tr>
		<td>날짜</td><td>제목</td><td>내용</td><td>글 작성자</td>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td>${v.pdate}</td><td>${v.title}</td><td>${v.content}</td><td>${v.writer}</td>
		</tr>
	</c:forEach>
</table>
<a href="insertBoard.jsp?writer=${name}">글 작성</a>
<a href="logout.jsp">로그아웃</a>
</body>
</html>