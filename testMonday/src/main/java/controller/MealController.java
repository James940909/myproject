package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.daymeal.DayMealService;
import model.daymeal.DayMealVO;
import model.meal.MealService;
import model.meal.MealVO;

@Controller
public class MealController {
	
	@Autowired
	MealService mealService;
	@Autowired
	DayMealService dayMealService;
	
	@RequestMapping("/selectOneMeal.do")
	public String selectOneMeal(HttpSession session, MealVO vo) {
		mealService.getMeal(vo);
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/selectAllMeal.do")
	public String selectAllMeal(HttpSession session, MealVO vo, Model model) {
		System.out.println("main.do 진입!");
		model.addAttribute("mdatas", mealService.getMealList(vo));
		System.out.println(model);
		return "kcalInfo.jsp";
	}
	
	@RequestMapping("/insertMeal.do")
	public String insertMeal(MealVO vo, Model model,DayMealVO dvo) {
		model.addAttribute("mdatas", mealService.getMealList(vo));
		model.addAttribute("ddatas", dayMealService.getDayMealList(dvo));
		model.addAttribute("m_num", vo.getM_num());
		return "insertMeal.jsp";
	}
	
	@RequestMapping("/deleteMeal.do")
	public String deleteMeal(HttpSession session, MealVO vo) {
		mealService.deleteMeal(vo);
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/updateMeal.do")
	public String updateMeal(HttpSession session, MealVO vo) {
		mealService.updateMeal(vo);
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/insertSessionMeal.do")
	public String insertSessionMeal(HttpSession session, MealVO vo, 
			@RequestParam(name="um_weight", required=false)Double um_weight,
			@RequestParam(name="category", required=false)String category) 
	
	{
		System.out.println("insertSessionMeal.do 진입!!");
		
		
		
		MealVO data = mealService.getMeal(vo);
		
		data.setM_num(vo.getM_num());
		data.setM_name(vo.getM_name());
		data.setM_weight(vo.getM_weight());
		data.setM_unit(vo.getM_unit());
		data.setM_kcal(vo.getM_kcal());
		
		
		System.out.println(session);
		System.out.println(data);
		
		session.setAttribute("category", category);
		session.setAttribute("MealInfo", data);
		session.setAttribute("kcalAll", (data.getM_kcal()/data.getM_weight())*um_weight);
		
		System.out.println(session);
		System.out.println(data);
		return "insertMeal.jsp";
	}

}
