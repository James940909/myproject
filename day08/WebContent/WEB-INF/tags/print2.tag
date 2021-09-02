<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>

<%@ attribute name="border" %>
<%@ attribute name="bgcolor" %>

<h1><jsp:doBody /></h1>

<jsp:useBean id="dataBean" class="model.DataBeanTest" />

<table border="${border}" bgcolor="${bgcolor}">
	<%
		for(String v:dataBean.getMenu()){
			out.println("<tr><td>"+v+"</td></tr>");
		}
	%>
	
</table>
