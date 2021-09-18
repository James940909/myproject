package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MessageVO;



public class DelmsgAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		// 1. rVO만들수있도록 get()
		// 2. rDAO로 insert()
		MessageDAO mDAO=new MessageDAO();
		MessageVO mVO=new MessageVO();
		mVO.setMid(Integer.parseInt(request.getParameter("mid")));
		mVO.setUserid(request.getParameter("userid"));
		
		if(mDAO.delete(mVO)) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('삭제 실패!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
