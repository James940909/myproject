<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${empty seUser}">
		<form method="post" action="login.do">
			<input type="hidden" name="mcnt" value="${mcnt}">
			<input type="text" name="userid">
			<input type="password" name="passwd">
			<input type="submit" value="로그인">
		</form>
	</c:when>
	<c:otherwise>
		<form method="post" action="logout.do">
			${seUser}님, 환영합니다!
			<input type="submit" value="로그아웃">
			<a href="main.do?mcnt=${mcnt}&selUser=${seUser}">내글목록보기</a>
		</form>
	</c:otherwise>
</c:choose>
