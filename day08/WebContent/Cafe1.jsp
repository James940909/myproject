<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <form method="post" action="Cafe2.jsp">
      <jsp:useBean id="dataBeanTest" class="model.DataBeanTest" scope="session" />
      <select name="data">
         <%
            for(String v:dataBeanTest.getMenu()){
               
         %>
            <option><%=v%></option>
         <%   
            }
         %>
      </select>
      
      <select name="cnt">
         <%
            for(int v:dataBeanTest.getCnt()){
               
         %>
            <option><%=v%></option>
         <%   
            }
         %>
      </select>
      
      <input type="submit" value="구매">
   </form>
   
</body>
</html>