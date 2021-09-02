<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매</title>
</head>
<body>

선택한 메뉴는 ${param.data}입니다. <br>
선택하신 메뉴의 구매 개수는 ${param.cnt}개 입니다. <br><br>

${param.data}, ${param.cnt}개의 가격은 ${dataBeanTest.total(param.data,param.cnt)}원입니다!



</body>
</html>