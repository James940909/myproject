package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.ReplyDAO;
import model.msg.ReplyVO;

public class DelrpAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		// 1. rVO������ֵ��� get()
		// 2. rDAO�� insert()
		ReplyDAO rDAO=new ReplyDAO();
		ReplyVO rVO=new ReplyVO();
		rVO.setRid(Integer.parseInt(request.getParameter("rid")));
		rVO.setUserid(request.getParameter("userid"));
		
		if(rDAO.delete(rVO)) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('���� ����!');history.go(-1);</script>");
		}
		
		return forward;
		
		
	}

}
