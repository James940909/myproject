<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="model.product.ProductVO" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="control.jsp?action=nowProduct">메인으로 돌아가기</a>

<hr>
<form action="control.jsp" method="post" name="form1">
<input type="hidden" name="action" value="update">
<table border="1">
	<tr>
		<td>상품명</td>
		<td><input type="text" name="name" value="<%=data.getName()%>"></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input type="text" name="price" value="<%=data.getPrice()%>"></td>
	</tr>
	<tr>
		<td colspan='2'><input type="submit" value="내용 변경하기"></td>
	</tr>
</table>
</form>
</body>
</html>