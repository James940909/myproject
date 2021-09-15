<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.msg.*,model.users.*"%>

<jsp:useBean id="mDAO" class="model.msg.MessageDAO" />
<jsp:useBean id="rDAO" class="model.msg.ReplyDAO" />
<jsp:useBean id="uDAO" class="model.users.UsersDAO" />
<jsp:useBean id="mVO" class="model.msg.MessageVO" />
<jsp:setProperty property="*" name="mVO"/>
<jsp:useBean id="rVO" class="model.msg.ReplyVO" />
<jsp:setProperty property="*" name="rVO"/>
<jsp:useBean id="uVO" class="model.users.UsersVO" />
<jsp:setProperty property="*" name="uVO"/>

<%
	String action=request.getParameter("action");
	String url="control.jsp?action=main";	
	String mcntt=request.getParameter("mcnt");
	int mcnt=0;
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url= url+ "&mcnt="+mcnt;
	String selUser=request.getParameter("selUser");
	if(selUser!=null){
		url= url+ "&selUser="+selUser;
	}
	
	
	if(action.equals("main")){
		ArrayList<MsgSet> datas=mDAO.selectAll(selUser, mcnt);
		ArrayList<UsersVO> newUsers=uDAO.selectAll();
		
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("selUser", selUser);
		request.setAttribute("mcnt", mcnt);
		
		pageContext.forward("main.jsp");
	}
	
	
	else if(action.equals("newmsg")){
		System.out.println(mVO);
		if(mDAO.insert(mVO)){
			response.sendRedirect(url);
		}
		else{
			throw new Exception("newmsg에서 발생!");
		}
	}
	
	else if(action.equals("newrp")){
		System.out.println(rVO);
		if(rDAO.insert(rVO)){
			response.sendRedirect(url);
		}
		else{
			throw new Exception("newrp에서 발생!");
		}
	}
	else if(action.equals("delrp")){
		if(rDAO.delete(rVO)){
			response.sendRedirect(url);
		}
		else{
			throw new Exception("delrp에서 발생!");
		}
	}
	
	else if(action.equals("delmsg")){
		if(mDAO.delete(mVO)){
			response.sendRedirect(url);
		}
		else{
			throw new Exception("delmsg에서 발생!");
		}
	}
	
	else if(action.equals("login")){
		if(uDAO.login(uVO)){
			session.setAttribute("seUser", uVO.getUserid());
			response.sendRedirect(url);
		}
		else{
			out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
	}
	else if(action.equals("logout")){
		session.invalidate();
		///session.removeAttribute("selUser");
		response.sendRedirect("control.jsp?action=main");
	}
	

	
	// 회원가입 기능
	else if(action.equals("insertU")){
		if(uDAO.insert(uVO)){
			out.println("<script>alert('회원가입 완료! 로그인후에 이용하세요! :D');window.close();</script>");
		}
		else{
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}	
	}
	
%>