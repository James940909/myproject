<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.MemberBean"
%>

<jsp:useBean id="MemberBean" class="model.MemberBean"/>
<jsp:setProperty property="*" name="MemberBean"/>

<%
	String action= request.getParameter("action");
	String ID=request.getParameter("ID");
	String PW=request.getParameter("PW");
	
	if(action.equals("login")){
		request.setAttribute("ID", ID);
		request.setAttribute("PW", PW);
		pageContext.forward("Login2.jsp");
	}
%>