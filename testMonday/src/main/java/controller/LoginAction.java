package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.testMember.testMemberDAO;
import model.testMember.testMemberVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;

		// 1. uVO�� ������ִ� ���ڵ��� get()
		// 2. �α��� ����,���п��� �Ǵ�
		// 3. ����: ���Ǽ��� / ����: ��ũ��Ʈ ���
		testMemberDAO tDAO=new testMemberDAO();
		testMemberVO tVO=new testMemberVO();
		tVO.setId(request.getParameter("id"));
		tVO.setPw(request.getParameter("pw"));


		if(tDAO.SelectOne(tVO) != null) {
			tVO = tDAO.SelectOne(tVO);
			HttpSession session=request.getSession();
			session.setAttribute("id", tVO.getId());
			session.setAttribute("pw", tVO.getPw());
			session.setAttribute("name", tVO.getName());
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8"); 
			out.println("<script>alert('���̵�� ��й�ȣ�� Ȯ�����ּ���!!!');history.go(-1);</script>");
		}

		return forward;
	}

}
