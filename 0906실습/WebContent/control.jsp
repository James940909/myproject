<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.post.*, model.member.*"
%>


<%
	request.setCharacterEncoding("UTF-8");
	String condition=request.getParameter("condition");
	String content=request.getParameter("content");
	System.out.println(condition+" "+content);
%>


<jsp:useBean id="postDAO" class="model.post.PostDAO"/>
<jsp:useBean id="memberDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="postVO" class="model.post.PostVO"/>
<jsp:useBean id="memberVO" class="model.member.MemberVO"/>
<jsp:setProperty property="*" name="postVO"/>
 <jsp:setProperty property="*" name="memberVO"/>

<%
	// 컨트롤러를 호출했을 때의 action 파라미터에 따라 작업을 분할
	String action = request.getParameter("action");
	System.out.println(action); // log출력
	System.out.println(session.getAttribute("mnum"));
	
	if(action.equals("nowPost")){
		ArrayList<PostVO> datas = postDAO.getDBList();
		request.setAttribute("datas", datas);
		pageContext.forward("nowPost.jsp");
	}
	else if(action.equals("insert")){
		if(postDAO.insertDB(postVO)){
			// 같은 페이지의 다른 곳으로 이동할 때는 주로 redirect 방식을 이용함 -> spring에서 자세히
			response.sendRedirect("control.jsp?action=nowPost");
		}
		else{
			// 예외를 발생시켜 에러페이지로 이동
			throw new Exception("DB 변경 오류 발생!");
		}
	}
	else if(action.equals("delete")){
		if(postDAO.deleteDB(postVO)){
			response.sendRedirect("control.jsp?action=nowPost");
			System.out.println("delete 정상적으로 작동!");
		}
		else{
			throw new Exception("DB 삭제 오류 발생!");
		}
	}
	else if(action.equals("update")){
		if(postDAO.updateDB(postVO)){
			// 같은 페이지의 다른 곳으로 이동할 때는 주로 redirect 방식을 이용함 -> spring에서 자세히
			response.sendRedirect("control.jsp?action=nowPost");
		}
		else{
			// 예외를 발생시켜 에러페이지로 이동
			throw new Exception("DB 변경 오류 발생!");
		}
	}
	else if(action.equals("edit")){
		
		int mnum = (int)session.getAttribute("mnum");
		PostVO data = postDAO.getDBData(postVO);
		System.out.println("data.getMnum() = " + data.getMember());
		System.out.println("mnum = " + mnum);
		
		if(data.getMember() == mnum){
			request.setAttribute("data", data);
			pageContext.forward("edit.jsp");	
		}
		else{
			out.println("<script>alert('접근 권한이 없습니다!');history.go(-1);</script>");
		}
	}
	// 로그인 기능
	else if(action.equals("login")){
		//MemberVO vo = memberDAO.login(memberVO);
		// System.out.println(vo.getmnum());
		
		if(memberDAO.login(memberVO) != null){
			session.setAttribute("mnum", memberDAO.login(memberVO).getMnum());
			response.sendRedirect("control.jsp?action=nowPost");
		}
		else{
		out.println("<script>alert('아이디 비밀번호를 확인하세요!');history.go(-1);</script>");
		}
	}
	// 회원가입 기능
	else if(action.equals("signUp")){
		if(memberDAO.insertDB(memberVO)){
			// 같은 페이지의 다른 곳으로 이동할 때는 주로 redirect 방식을 이용함 -> spring에서 자세히
			pageContext.forward("main.jsp");
		}
		else{
			// 예외를 발생시켜 에러페이지로 이동
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}	
	}
	// 글 읽기
	else if(action.equals("read")){
		PostVO data = postDAO.getDBData(postVO);
		request.setAttribute("data", data);
		pageContext.forward("read.jsp");	
	}
	
	// 검색
	else if(action.equals("search")){
		ArrayList<PostVO> datas=postDAO.searchAll(condition,content);
		for(PostVO data: datas){
			System.out.println(data);
		}
		request.setAttribute("datas",datas);
		pageContext.forward("nowPost.jsp");
	}
	
	//내글 보기
	else if(action.equals("mylist")){
		int member = (int)session.getAttribute("mnum");
		PostVO vo = new PostVO();
		vo.setMember(member);
		ArrayList<PostVO> datas=postDAO.myListAll(vo);
		for(PostVO data: datas){
			System.out.println(data);
		}
		request.setAttribute("datas",datas);
		pageContext.forward("mypage.jsp");
	}
	
	//로그아웃
	else if(action.equals("logout")){
		session.invalidate();
		pageContext.forward("main.jsp");
	}
	
	else{
		out.println("오류 발생!");
	}
%>