<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="mid" %>
<%@ attribute name="userid" %>

<c:if test="${seUser == userid}">
	<a href="control.jsp?action=delrp&mid=${mid}&mcnt=${mcnt}">삭제</a>
</c:if>