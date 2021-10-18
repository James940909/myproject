package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.testBoard.testBoardDAO;
import model.testBoard.testBoardVO;
import model.testMember.testMemberVO;

public class insertBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;

		testBoardVO tVO= new testBoardVO();
		testBoardDAO tDAO = new testBoardDAO();
		testMemberVO mVO= new testMemberVO();

		tVO.setWriter(request.getParameter("writer"));
		tVO.setContent(request.getParameter("content"));
		tVO.setTitle(request.getParameter("title"));
		mVO.setName(request.getParameter("name"));

		if(tDAO.insertBoard(tVO)) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			try {
				throw new Exception("insertBoardAction 오류 발생!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return forward;
	}

}
