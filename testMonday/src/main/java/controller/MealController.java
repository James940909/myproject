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
		
		// �������� 1,2,3... �迭�� ����
		List<Integer> page = new ArrayList<Integer>();
		
		// default���� page!
		List<String> activeValue = new ArrayList<String>();
		
		
		// ��ü meal����Ʈ�� 10���� �߶� ���ο� ����Ʈ ����.
		//List<MealVO> newMdatas = mdatas.subList(0+((num-1)*10), 10+((num-1)*10));
		
		int pageSize = mdatas.size();
		int pageValue = 0; //������ ����
		if(pageSize%10==0) { // 10���� �� ��������.
			pageValue = pageSize/10;
			List<MealVO> newMdatas = mdatas.subList(0+((num-1)*10), 10+((num-1)*10));
			model.addAttribute("mdatas", newMdatas);
		}
		else { // 10���� �������� �������� �����Ҷ� ������ +1 
			pageValue = (pageSize/10)+1;
			if(pageValue==num) { //������ ������ Ŭ����, �������� �ε��� ������ ���
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
