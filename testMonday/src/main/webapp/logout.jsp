<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	out.println("<script>alert('로그아웃이  되었습니다!')");
%>

<%
	session.invalidate();
	pageContext.forward("login.jsp");
%>