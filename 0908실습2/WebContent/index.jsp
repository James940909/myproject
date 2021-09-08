<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.product.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<form action="control.jsp" method="post" name="form1">
	<input type="hidden" name="action" value="insert">
	<h2>~~~4조참치~~~</h2>
	<table border="1">
		<th>물품 등록</th>
		<tr>
			<td>상품</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input type="text" name="price"></td>
		</tr>
		<tr>
			<td colspan='2' align="right"><input type="submit" value="등록하기"></td>
		</tr>
	</table>
</form>


<table border="1">
	<tr>
		<th>상품명</th><th>가격</th>
	</tr>
	<c:forEach var="v" items="${datas}">
	<tr>
		<td><a href="control.jsp?action=delete&name=${v.getName()}">${v.getName()}</a></td>
		<td><a href="control.jsp?action=edit&name=${v.getName()}">${v.getPrice()}</a></td>
	</tr>
	</c:forEach>
</table>

<form action="control.jsp" method="post">
<input type="hidden" name="action" value="search">
<select name="condition">
	<option selected value="name">상품명</option>
	<option value="price">가격</option>
</select>
<input type="text" name="content">
<input type="submit" value="검색하기">
</form>

</body>
</html>