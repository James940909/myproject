package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.users.UsersDAO;
import model.users.UsersVO;

public class InsertUAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward=null;
		
		UsersDAO uDAO=new UsersDAO();
		UsersVO uVO=new UsersVO();
		uVO.setUserid(request.getParameter("userid"));
		uVO.setPasswd(request.getParameter("passwd"));
		uVO.setName(request.getParameter("name"));
		
		if(uDAO.insert(uVO)) {
			response.setContentType("text/html; charset=UTF-8");
			forward=new ActionForward();
			PrintWriter out=response.getWriter();
			out.println("<script>alert('회원가입 완료! 로그인후에 이용하세요! :D');window.close();</script>");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('가입 실패!');history.go(-1);</script>");
		}
		
		
		return forward;
	}

}
