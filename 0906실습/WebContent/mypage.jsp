<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.post.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<% int mnum = (int)session.getAttribute("mnum"); %>
</head>
<body>
<a href="control.jsp?action=nowPost">메인으로 돌아가기</a>
<form action="control.jsp" method="post">
<input type="hidden" name="action" value="mylist">
<button>나의 게시물 보기!</button>
</form>
<form action="control.jsp" method="post" name="form1">
<input type="hidden" name="action" value="insert">
<input type="hidden" name="member" value="<%=mnum%>">
<table border="1">
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer"></td>
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

<table border="1">
	<tr>
		<th>글 번호</th><th>제목</th><th>작성자</th><th>작성일</th>
	</tr>
	<c:forEach var="v" items="${datas}">
	<tr>
		<td><a href="control.jsp?action=edit&pnum=${v.getPnum()}">${v.getPnum()}</a></td>
		<td><a href="control.jsp?action=read&pnum=${v.getPnum()}">${v.getTitle()}</a></td>
		<td>${v.getWriter()}</td>
		<td>${v.getWdate()}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>