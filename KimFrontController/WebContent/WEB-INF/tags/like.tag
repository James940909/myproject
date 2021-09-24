<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="mid" %>
<%@ attribute name="userid" %>
<c:choose>
	<c:when test="${empty seUser}">
		<a>X</a>
	</c:when>
	<c:otherwise>
		<a href="update.do?mid=${mid}&mcnt=${mcnt}&selUser=${selUser}">♥</a>
	</c:otherwise>
</c:choose>