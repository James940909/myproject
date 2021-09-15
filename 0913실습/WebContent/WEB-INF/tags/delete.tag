<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="rid" %>
<%@ attribute name="userid" %>
<%@ attribute name="mid" %>
<%@ attribute name="type" %>

<c:choose>

<c:when test="${type=='deleteR'}">
<c:if test="${seUser == userid}">
	<a href="control.jsp?action=delrp&rid=${rid}&mcnt=${mcnt}">삭제</a>
</c:if>
</c:when>

<c:when test="${type=='deleteM'}">
<c:if test="${seUser == userid}">
	<a href="control.jsp?action=delmsg&mid=${mid}&mcnt=${mcnt}">삭제</a>
</c:if>
</c:when>
</c:choose>