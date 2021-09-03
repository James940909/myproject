<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	if(session.getAttribute("mem")==null){
	%>
		<mytag:login />
	<%
	}
	else{
	%>
		<mytag:logout />
	<%
	}
	%>

</body>
</html>