package controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.users.UsersService;
import model.users.UsersVO;
import model.meal.MealVO;
import model.meal.MealService;

@Controller
public class UsersController {
	
	
	@Autowired
	UsersService usersService;
	@Autowired
	MealService mealService;
	
	@RequestMapping("/main.do")
	public String mainAction(MealVO mvo, Model model,UsersVO uvo) {
		List<UsersVO> udatas = usersService.getUsersList(uvo);
		System.out.println(udatas);
		model.addAttribute("udatas", udatas);
		System.out.println("main.do 진입!");
		return "main.jsp";
	}
	
	@RequestMapping(value="/myLogin.do", method=RequestMethod.POST)
	public String PmyLogin(HttpSession session, UsersVO vo) {
		System.out.println("myLogin.do 진입!");
		
		if(vo.getId()==null || vo.getId().equals("")){
			throw new IllegalArgumentException("로그인 에러!");	
		}
		UsersVO data = usersService.getUsers(vo);
		/*if(vo.getId().isEmpty() || vo.getPw().isEmpty()) {
			
		}*/
		if(data!=null) {
			System.out.println("data가 존재!");
			/*session.setAttribute("u_num", data.getU_num());
			session.setAttribute("id", data.getId());
			session.setAttribute("pw", data.getPw());
			session.setAttribute("u_name", data.getU_name());*/
			session.setAttribute("userInfoData", data);
			return "redirect:main.do";
		}
	
		else{
			return "redirect:myLogin.do";
		}
		
	}
	
	@RequestMapping(value="/myLogin.do", method=RequestMethod.GET)
	public String GmyLogin(HttpSession session, UsersVO vo) {
		System.out.println("myLogin.do 진입!");
		
		if(vo.getId()==null || vo.getId().equals("")){
			throw new IllegalArgumentException("로그인 에러!");	
		}
		UsersVO data = usersService.getUsers(vo);
		/*if(vo.getId().isEmpty() || vo.getPw().isEmpty()) {
			
		}*/
		if(data!=null) {
			System.out.println("data가 존재!");
			/*session.setAttribute("u_num", data.getU_num());
			session.setAttribute("id", data.getId());
			session.setAttribute("pw", data.getPw());
			session.setAttribute("u_name", data.getU_name());*/
			session.setAttribute("userInfoData", data);
			return "redirect:main.do";
		}
	
		else{
			return "redirect:myLogin.do";
		}
		
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("logout.do 진입!");
		session.invalidate();
		return "redirect:main.do";
	}
	
	@RequestMapping("/insertUsers.do")
	public String insertUsers(UsersVO vo) {
		System.out.println("insertUsers.do 진입!");
		usersService.insertUsers(vo);
		return "redirect:main.do";
	}
	
	@RequestMapping("/deleteUsers.do")
	public String deleteUsers(HttpSession session, UsersVO vo) {
		System.out.println("deleteUsers.do 진입!");
		usersService.deleteUsers(vo);
		session.invalidate();
		return "main.do";
	}
	
	@RequestMapping("/updateUsers.do")
	public String updateUsers(UsersVO vo) {
		System.out.println("updateUsers.do 진입!");
		usersService.updateUsers(vo);
		return "redirect:main.do";
	}

}
