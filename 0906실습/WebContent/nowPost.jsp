<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.post.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록 화면</title>


</head>
<body>
<h2>게시글 목록</h2>
<hr>
<a href="mypage.jsp">글 등록</a>
<form action="control.jsp" method="post">
<input type="hidden" name="action" value="logout">
<button>로그아웃</button>

</form>


<!--
<form action="control.jsp" method="post">
<input type="hidden" name="action" value="mylist">
<button>나의 게시물 보기!</button>
</form>
-->

<hr>
<!--<table border="1">
	<tr>
		<th>글 번호</th><th>제목</th><th>작성자</th><th>작성일</th>
	</tr>
	<%
		for(PostVO vo:(ArrayList<PostVO>)datas){
			
	%>
	<tr>
		<td><a href="control.jsp?action=edit&pnum=<%=vo.getPnum()%>"><%=vo.getPnum()%></a></td>
		<td><a href="control.jsp?action=read&pnum=<%=vo.getPnum()%>"><%=vo.getTitle() %></a></td>
		<td><%=vo.getWriter() %></td>
		<td><%=vo.getWdate() %></td>
	</tr>
	<%
		}
	%>
</table>
-->

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

<form action="control.jsp" method="post">
<input type="hidden" name="action" value="search">
<select name="condition">
	<option selected value="title">제목</option>
	<option value="writer">작성자</option>
</select>
<input type="text" name="content">
<input type="submit" value="검색하기">
</form>

</body>
</html>