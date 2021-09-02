<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless" %>


<%@ attribute name="border" %>
<%@ attribute name="bgcolor" %>

<h1><jsp:doBody /></h1>


<jsp:useBean id="memberBean" class="model.MemberBean" />

<form action="control.jsp" method="post">
<input type="hidden" name="action" value="login">
<table border="${border}" bgcolor="${bgcolor}">
	<tr>
		<td>ID</td>
		<td><input type="text" placeholder="ID를 입력하세요"></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" placeholder="PW를 입력하세요"></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="로그인"></td>
	</tr>
</table>
</form>