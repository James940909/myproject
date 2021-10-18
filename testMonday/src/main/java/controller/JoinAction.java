package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.testMember.testMemberDAO;
import model.testMember.testMemberVO;

public class JoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		ActionForward forward = null;
	
		testMemberDAO tDAO=new testMemberDAO();
		testMemberVO tVO=new testMemberVO();
	
		tVO.setId(request.getParameter("id"));
		tVO.setPw(request.getParameter("pw"));
		tVO.setName(request.getParameter("name"));
		
		
		if(tDAO.insertMember(tVO)) {
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('회원가입 완료! 로그인후에 이용하세요! :D');location.href='login.jsp';</script>");
		}
		else {
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}
		return forward;
	}

}
