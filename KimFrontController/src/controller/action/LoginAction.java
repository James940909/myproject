package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.users.UsersDAO;
import model.users.UsersVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		UsersDAO uDAO=new UsersDAO();
		UsersVO uVO=new UsersVO();
		uVO.setUserid(request.getParameter("userid"));
		uVO.setPasswd(request.getParameter("passwd"));
		
		if(uDAO.login(uVO)) {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", uVO.getUserid());
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
