package controller;




import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.daymeal.DayMealService;
import model.daymeal.DayMealVO;
import model.meal.MealService;
import model.meal.MealVO;
import model.users.UsersService;
import model.users.UsersVO;

@Controller
public class UsersController {
	
	
	@Autowired
	UsersService usersService;
	@Autowired
	MealService mealService;
	@Autowired
	DayMealService dayMealService;
	
	@RequestMapping("/main.do")
	public String mainAction(MealVO mvo, UsersVO uvo, DayMealVO dvo, Model model) {
		System.out.println("main.do 진입!");
		
		String newsUrl="https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=103&sid2=241";
		Connection conn = Jsoup.connect(newsUrl);
		
		try {
			Document document = conn.get();
			Elements imageUrlElements = document.getElementsByClass("photo");
			Elements contentElements = document.getElementsByClass("lede");
			List<String> title = new ArrayList<String>();
			List<String> imgUrl = new ArrayList<String>();
			List<String> content = new ArrayList<String>();
			List<String> newsImg = new ArrayList<String>();
			
			
			
			for(Element v:imageUrlElements) {
				//System.out.println(v.select("a").attr("href"));
				//System.out.println(v.select("img").attr("alt"));
				title.add(v.select("img").attr("alt"));
				imgUrl.add(v.select("a").attr("href"));
				newsImg.add(v.select("img").attr("src"));
			}
			
			for(Element v:contentElements) {
				content.add(v.text());
			}
			model.addAttribute("title", title);
			model.addAttribute("imgUrl", imgUrl);
			model.addAttribute("content", content);
			model.addAttribute("newsImg", newsImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	public String insertUsers(UsersVO vo,
		@RequestParam(name="fileUpload",required=false) MultipartFile fileUpload) throws IllegalStateException, IOException
	{
		//C:\\Users\\dsschool\\git\\myproject\\testMonday\\src\\main\\webapp\\images >> 경로
		fileUpload=vo.getFileUpload();
		System.out.println("insertUsers.do 진입!");
		String OriginalFile = fileUpload.getOriginalFilename();
		System.out.println("파일이름: "+OriginalFile);
		String OriginalFileExtension = OriginalFile.substring(OriginalFile.lastIndexOf("."));
		System.out.println("확장자: "+OriginalFileExtension);
		String FilePath = "C:\\Users\\dsschool\\git\\myproject\\testMonday\\src\\main\\webapp\\images\\";
		String NewFileName = vo.getId()+OriginalFileExtension;
		if(!fileUpload.isEmpty()) {
			File file = new File(FilePath+NewFileName);
			fileUpload.transferTo(file);
		}
		vo.setU_profile(NewFileName);
		//표준 체중((키-100) X 0.9) X 활동 지수(32.5)
		vo.setU_daykcal(((vo.getU_height()-100)*0.9)*32.5);
		usersService.insertUsers(vo);
		return "main.do";
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
	
	@RequestMapping("/ranking.do")
	public String ranking(UsersVO vo, Model model) {
		System.out.println("ranking.do 진입!");
		List<UsersVO> datas = usersService.ranking(vo);
		
		model.addAttribute("ranking", datas);
		return "ranking.jsp";
	}

}
