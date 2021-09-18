package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.msg.ReplyDAO;
import model.msg.ReplyVO;

public class NewrpAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		// 1. rVO만들수있도록 get()
		// 2. rDAO로 insert()
		ReplyDAO rDAO=new ReplyDAO();
		ReplyVO rVO=new ReplyVO();
		rVO.setMid(Integer.parseInt(request.getParameter("mid")));
		rVO.setRmsg(request.getParameter("rmsg"));
		rVO.setUserid(request.getParameter("userid"));
		
		if(rDAO.transCU(rVO)) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('댓글등록 실패!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
