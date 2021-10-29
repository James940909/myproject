package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.daymeal.DayMealService;
import model.daymeal.DayMealVO;
import model.meal.MealService;
import model.meal.MealVO;
import model.users.UsersVO;




@Controller
public class DayMealController {
	
	@Autowired
	DayMealService dayMealService;
	@Autowired
	MealService mealService;
	
	@RequestMapping("/selectOneDayMeal.do")
	public String selectOneDayMeal(HttpSession session, DayMealVO vo) {
		dayMealService.getDayMeal(vo);
		return "redirect:main.jsp";
	}
	
	@RequestMapping("/selectAllDayMeal.do")
	public String selectAllDayMeal(HttpSession session, DayMealVO vo) {
		dayMealService.getDayMealList(vo);
		return "redirect:main.jsp";
	}
	
	@RequestMapping("/insertDayMeal.do")
	public String insertDayMeal(HttpSession session, DayMealVO dvo, MealVO mvo, Model model) {
		
		
		model.addAttribute("dayMealInfo", dayMealService.getDayMealList(dvo));
		model.addAttribute("d_num", dvo.getD_num());
		System.out.println("insertDayMeal.do 1진입!");
		
		mvo.setM_name(dvo.getD_name());
		MealVO data = mealService.searchKcal(mvo);
		
		
		UsersVO udata = (UsersVO) session.getAttribute("userInfoData");
		//표준 체중((키-100) X 0.9) X 활동 지수(32.5)
		Double kcal = ((udata.getU_height()-100)*0.9)*32.5;
		dvo.setD_users(udata.getU_num());
		dvo.setD_daykcal(kcal);
		dvo.setD_userskcal(data.getM_kcal());
		
		dayMealService.insertDayMeal(dvo);
		System.out.println("insertDayMeal.do 2진입!");
		System.out.println(dvo);
		return "insertMeal.jsp";
	}
	
	@RequestMapping("/deleteDayMeal.do")
	public String deleteDayMeal(HttpSession session, DayMealVO vo) {
		
		vo.setD_num(vo.getD_num());
		dayMealService.deleteDayMeal(vo);
		return "insertMeal.do";
	}
	
	@RequestMapping("/updateDayMeal.do")
	public String updateDayMeal(HttpSession session, DayMealVO vo) {
		dayMealService.updateDayMeal(vo);
		return "redirect:main.jsp";
	}

}
