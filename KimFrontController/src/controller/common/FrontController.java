package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.DelmsgAction;
import controller.action.DelrpAction;
import controller.action.InsertUAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.NewmsgAction;
import controller.action.NewrpAction;
import controller.action.UpdateAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 사용자의 요청을 분석
		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String action=uri.substring(cp.length());
				
		ActionForward forward=null;
		// 2) 컨트롤러랑 매핑
		if(action.equals("/main.do")) {
			forward=new MainAction().execute(request, response);
		}
		else if(action.equals("/newmsg.do")) {
			forward=new NewmsgAction().execute(request, response);
		}
		else if(action.equals("/newrp.do")) {
			forward=new NewrpAction().execute(request, response);
		}
		else if(action.equals("/delrp.do")) {
			forward=new DelrpAction().execute(request, response);
		}
		else if(action.equals("/delmsg.do")) {
			forward=new DelmsgAction().execute(request, response);
		}
		else if(action.equals("/login.do")) {
			forward=new LoginAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) {
			forward=new LogoutAction().execute(request, response);
		}
		else if(action.equals("/update.do")) {
			forward=new UpdateAction().execute(request, response);
		}
		else if(action.equals("/insertU.do")) {
			forward=new InsertUAction().execute(request, response);
			return;
		}
		else {
			// 에러페이지랑 연결
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
				
		// 3) 사용자에게 결과 화면 출력
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.setContentType("text/html; charset=UTF-8");
				response.sendRedirect(forward.getPath());
			}
			else {
				response.setContentType("text/html; charset=UTF-8");
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}
		
		
	}

}
