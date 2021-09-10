<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>



<form action="control.jsp" method="post" name="form1">
	<input type="hidden" name="action" value="send">
	<h3>보낸사람</h3>
	<select name="sender">	
		 <c:forEach var="v" items="${datas}">
			 <option>${v.name}</option>	
		 </c:forEach>
	</select>
	<br>
	<h3>받는사람</h3>
	<select name="receiver">	
		 <c:forEach var="v" items="${datas}">
			 <option>${v.name}</option>	
		 </c:forEach>
	</select>
	<br>
	<h3>금액</h3>
	<input type="text" name="money">
	<br>
	<input type="submit" value="송금하기">
</form>

<hr>
<table border="1">
	
	<th>은행</th><th>잔액</th>
	
	<c:forEach var="v" items="${datas}">
		<tr>
			<td>${v.name}</td>
			<td>${v.money}</td>
		</tr>
	</c:forEach>
</table>
<hr>
<c:if test="${msg!=null}">
결과: ${msg}
</c:if>
</body>
</html>