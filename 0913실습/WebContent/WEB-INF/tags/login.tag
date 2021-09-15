<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="control.jsp" method="post">
<c:choose>
	<c:when test="${empty seUser}">
		<input type="hidden" name="mcnt" value="${mcnt}">
		<input type="hidden" name="action" value="login">
		<input type="text" name="userid">
		<input type="password" name="passwd">
		<input type="submit" value="로그인">
	</c:when>
	<c:otherwise>
		${seUser}님, 환영합니다!
		<input type="hidden" name="action" value="logout">
		<input type="submit" value="로그아웃">
		<a href="control.jsp?action=main&mcnt=${mcnt}&selUser=${seUser}">내글목록보기</a>
	</c:otherwise>
</c:choose>
</form>