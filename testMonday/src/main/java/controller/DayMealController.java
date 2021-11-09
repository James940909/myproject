package controller;

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
import model.meal.MealVO;
import model.totalmeal.TotalMealService;
import model.totalmeal.TotalMealVO;
import model.users.UsersService;
import model.users.UsersVO;




@Controller
public class DayMealController {
	
	@Autowired
	DayMealService dayMealService;
	@Autowired
	MealService mealService;
	@Autowired
	UsersService usersService;
	@Autowired
	TotalMealService totalMealService;
	
	@RequestMapping("/selectOneDayMeal.do")
	public String selectOneDayMeal(HttpSession session, DayMealVO vo) {
		dayMealService.getDayMeal(vo);
		return "redirect:main.jsp";
	}
	
	@RequestMapping("/selectAllDayMeal.do")
	public String selectAllDayMeal(HttpSession session, DayMealVO dvo, MealVO mvo, Model model) {
		
		UsersVO udata = (UsersVO) session.getAttribute("userInfoData");
		dvo.setD_users(udata.getU_num());
		
		List<MealVO> mdatas = mealService.getMealList(mvo);
		List<DayMealVO> ddatas = dayMealService.getDayMealList(dvo);
		//아점저외 출력
		List<DayMealVO> morning = dayMealService.morningDayMealList(dvo);
		List<DayMealVO> lunch = dayMealService.lunchDayMealList(dvo);
		List<DayMealVO> dinner = dayMealService.dinnerDayMealList(dvo);
		List<DayMealVO> other = dayMealService.otherDayMealList(dvo);
		
		
		Double TotalKcal = 0.0;
		for(int i=0;i<ddatas.size();i++) {
			TotalKcal+=ddatas.get(i).getD_userskcal();
		}
		Double NewTotalKcal = Math.round((TotalKcal*100))/100.0; //소숫점 2째 자리까지 반환.
		
		model.addAttribute("totalKcal", NewTotalKcal);
		model.addAttribute("mdatas", mdatas);
		model.addAttribute("morning", morning);
		model.addAttribute("lunch", lunch);
		model.addAttribute("dinner", dinner);
		model.addAttribute("other", other);
		
		return "insertMeal.jsp";
	}
	
	@RequestMapping("/insertDayMeal.do")
	public String insertDayMeal(HttpSession session, UsersVO uvo, DayMealVO dvo, MealVO mvo, Model model,
			@RequestParam(name="d_weight",required=false)Double d_weight)
	{
		
		// 메뉴를 골랐을때, 그 메뉴의 칼로리가 몇인지 알기위해!
		mvo.setM_name(dvo.getD_name());
		MealVO data = mealService.searchKcal(mvo);
		// d_users set에 필요함!
		UsersVO udata = (UsersVO) session.getAttribute("userInfoData");
		
		dvo.setD_num(dvo.getD_num());
		dvo.setD_users(udata.getU_num());
		dvo.setD_userskcal((data.getM_kcal()/data.getM_weight())*dvo.getD_weight());
		dayMealService.insertDayMeal(dvo);
		return "selectAllDayMeal.do";
	}
	
	@RequestMapping("/deleteDayMeal.do")
	public String deleteDayMeal(HttpSession session, DayMealVO vo) {
		dayMealService.deleteDayMeal(vo);
		return "selectAllDayMeal.do";
	}
	
	@RequestMapping("/updateDayMeal.do")
	public String updateDayMeal(HttpSession session, DayMealVO vo) {
		dayMealService.updateDayMeal(vo);
		return "redirect:main.jsp";
	}
	
	@RequestMapping("/totalDayMealtest.do")
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
		}
		else {
			tvo.setT_ox("X");
		}
		totalMealService.insertTotalMeal(tvo);
		
		List<TotalMealVO> tdatas = totalMealService.getTotalMealList(tvo);
		
		model.addAttribute("tdatas", tdatas);
		
		return "myMealInfo.jsp";
	}

}
