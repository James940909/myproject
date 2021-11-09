package controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.daymeal.DayMealService;
import model.daymeal.DayMealVO;
import model.meal.MealService;
import model.totalmeal.TotalMealService;
import model.totalmeal.TotalMealVO;
import model.users.UsersService;
import model.users.UsersVO;




@Controller
public class TotalMealController {
	
	@Autowired
	DayMealService dayMealService;
	@Autowired
	MealService mealService;
	@Autowired
	UsersService usersService;
	@Autowired
	TotalMealService totalMealService;
	
	@RequestMapping("/mainTotalMeal.do")
	public String mainTotalMeal(HttpSession session, TotalMealVO tvo, Model model) throws ParseException {
		UsersVO udata = (UsersVO) session.getAttribute("userInfoData");
		tvo.setT_num(udata.getU_num());
		
		List<TotalMealVO> tdatas = totalMealService.getTotalMealList(tvo);
	
		model.addAttribute("tdatas", tdatas);
		
		return "myMealInfo.jsp"; 
	}
	
	
	@RequestMapping("/totalDayMeal.do")
	public String totalDayMeal(HttpSession session, DayMealVO dvo, UsersVO uvo, TotalMealVO tvo, Model model,
			@RequestParam(name="totalKcal",required=false)Double totalKcal) 
	
	{
		UsersVO udata = (UsersVO) session.getAttribute("userInfoData");
		tvo.setT_num(udata.getU_num());
		tvo.setT_users(udata.getU_name());
		tvo.setT_daykcal(udata.getU_daykcal());
		tvo.setT_userskcal(totalKcal);
		if(udata.getU_daykcal()>=totalKcal) {
			tvo.setT_ox("O");
			uvo.setU_num(udata.getU_num());
			usersService.cntUp(uvo);
		}
		else {
			tvo.setT_ox("X");
		}
		totalMealService.insertTotalMeal(tvo);
		dvo.setD_users(udata.getU_num());
		dayMealService.allDelete(dvo);
		
		return "mainTotalMeal.do";
	}

}
