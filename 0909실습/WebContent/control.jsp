<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.bank1.*"
%>
    
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="bank1DAO" class="model.bank1.Bank1DAO"/>
<jsp:useBean id="bank1VO" class="model.bank1.Bank1VO"/>
<jsp:setProperty property="*" name="bank1VO"/>

<%
	String action = request.getParameter("action");
	
	if(action.equals("index")){
		ArrayList<Bank1VO> datas = bank1DAO.getBank1List();
		request.setAttribute("datas", datas);
		pageContext.forward("index.jsp");
	}
	else if(action.equals("send")){
		System.out.println(request.getParameter("money")); 
		Bank1VO vo = new Bank1VO();
		Bank1VO vo1 = new Bank1VO();
		vo.setName(request.getParameter("sender"));
		vo1.setName(request.getParameter("receiver"));
		if(request.getParameter("money").equals("")){
			session.setAttribute("msg", "송금불가! 금액을 입력하세요");
		}
		else{
			vo1.setMoney(Integer.parseInt(request.getParameter("money")));
			if(bank1DAO.trans(vo, vo1)){
				session.setAttribute("msg", "송금완료!");
			}
			
			else{
				session.setAttribute("msg", "송금불가! 잔액부족!");
			}
		}
		response.sendRedirect("control.jsp?action=index");
	}
%>
