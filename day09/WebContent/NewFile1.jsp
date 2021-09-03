<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="lb" class="model.LoginBean" />
<%
	String action=request.getParameter("action");
	if(action.equals("login")){
	if(lb.select(request.getParameter("uid"))){
		session.setAttribute("mem", "kim");
		pageContext.forward("NewFile.jsp");
	}
	else{
		pageContext.forward("NewFile.jsp");
	}
	}
	else{
		session.invalidate();
		pageContext.forward("NewFile.jsp");
	}
%>