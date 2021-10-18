package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.testBoard.testBoardDAO;
import model.testBoard.testBoardVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		testBoardDAO tDAO=new testBoardDAO();
		ArrayList<testBoardVO> datas=tDAO.SelectAll();

		request.setAttribute("datas", datas);
		

		forward.setRedirect(false);
		forward.setPath("main.jsp");

		return forward;
	}

}
