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

<!-- else는 없다!-->
<c:set var="msg" value="user" />
<c:if test="${msg=='test'}" var="res">
	1의 결과는 [${res}]    <!-- 이곳을 바디태그라 한다! -->
</c:if> 

<c:if test="${msg!='test'}" var="res">
	2의 결과는 [${res}]    <!-- 이곳을 바디태그라 한다! -->
</c:if>

</body>
</html>