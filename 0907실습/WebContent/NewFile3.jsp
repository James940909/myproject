<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<%
	ArrayList<String> datas=new ArrayList();
	datas.add("사과");
	datas.add("바나나");
	datas.add("키위");
	datas.add("참외");
	pageContext.setAttribute("datas",datas);
%>

<ol>
<c:forEach var="v" items="${datas}">
	<li>${v}</li>
</c:forEach>
</ol>

<form>
<table border="1">
		<tr>
			<td>정수를 입력하세요!</td>
			<td><input type="text" name="number"></td>
		</tr>
		<tr>
			<td colspan='2' align="right"><input type="submit" value="입력완료"></td>
		</tr>
</table>
</form>
<br>

<c:if test="${param.number%2==0}">
	짝수    <!-- 이곳을 바디태그라 한다! -->
</c:if> 

<c:if test="${param.number%2!=0}">
	홀수    <!-- 이곳을 바디태그라 한다! -->
</c:if>

</body>
</html>