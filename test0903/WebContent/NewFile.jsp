<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>&lt;c:forEach&gt;실습</h1>
<hr>

<table border="1">
	<c:forEach var="v" items="${members}">
	<!--      for(String v: datas)        -->
	<tr>
		<td>${v.name}</td>
		<td>${v.email}</td>
		
	</tr>
	</c:forEach>
</table>

<table border="1">
	<c:forEach var="v" items="${members}"> <!-- cout은 자주 쓰이진 않지만, foreach는 자주쓰인다! -->
	<!--      for(String v: datas)        -->
	<tr>
		<td>${v.name}</td>
		<td><c:out value="${v.email}" escapeXml="false"><font color="red">email 정보 없음</font></c:out></td>
		<!-- c:out은 출력할때 쓴다. 값이 없으면 바디쪽 내용이 출력!  escapeXml="false" 가 없으면 문자 (위의 경우 font)그대로 출력되기때문에 넣어줘야함!-->
		
	</tr>
	</c:forEach>
</table>




</body>
</html>