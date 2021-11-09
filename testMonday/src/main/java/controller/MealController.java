package controller;

import java.util.ArrayList;
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
	public String selectAllMeal(HttpSession session, MealVO vo, Model model,
			@RequestParam(name="num",required=false,defaultValue="1")Integer num) {
		List<MealVO> mdatas = mealService.getMealList(vo); 
		
		// 페이지수 1,2,3... 배열에 저장
		List<Integer> page = new ArrayList<Integer>();
		
		// default값은 page!
		List<String> activeValue = new ArrayList<String>();
		
		
		// 전체 meal리스트를 10개로 잘라서 새로운 리스트 생성.
		//List<MealVO> newMdatas = mdatas.subList(0+((num-1)*10), 10+((num-1)*10));
		
		int pageSize = mdatas.size();
		int pageValue = 0; //페이지 개수
		if(pageSize%10==0) { // 10으로 딱 떨어질때.
			pageValue = pageSize/10;
			List<MealVO> newMdatas = mdatas.subList(0+((num-1)*10), 10+((num-1)*10));
			model.addAttribute("mdatas", newMdatas);
		}
		else { // 10으로 나눴을때 나머지가 존재할때 페이지 +1 
			pageValue = (pageSize/10)+1;
			if(pageValue==num) { //마지막 페이지 클릭시, 나머지값 인덱스 까지만 출력
				List<MealVO> newMdatas = mdatas.subList(0+((num-1)*10), 0+((num-1)*10)+(pageSize%10));
				model.addAttribute("mdatas", newMdatas);
			}
			else {
				List<MealVO> newMdatas = mdatas.subList(0+((num-1)*10), 10+((num-1)*10));
				model.addAttribute("mdatas", newMdatas);
			}
			
		}
		for(int i=0;i<pageValue;i++) {
			page.add(i+1);
			activeValue.add("page");
		}
		activeValue.remove(num-1);
		activeValue.add(num-1, "page active");
		
		
		model.addAttribute("num", num);
		model.addAttribute("page", page);
		model.addAttribute("activeValue", activeValue);
		
		return "kcalInfo.jsp";
	}
	
	@RequestMapping("/insertMeal.do")
	public String insertMeal(MealVO vo, Model model,DayMealVO dvo) {
		vo.setM_num(vo.getM_num());
		mealService.insertMeal(vo);
		return "selectAllMeal.do";
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
	
	@RequestMapping("/searchMealName.do")
	public String searchMealName(MealVO vo, Model model) {
		model.addAttribute("mdatas", mealService.searchMealName(vo));
		return "kcalInfo.jsp";
	}

}
