package model.meal;

import java.util.List;

public interface MealService {
	void insertMeal(MealVO vo);
	void updateMeal(MealVO vo);
	void deleteMeal(MealVO vo);
	List<MealVO> getMealList(MealVO vo);
	MealVO getMeal(MealVO vo);
	MealVO searchKcal(MealVO vo);
	List<MealVO> searchMealName(MealVO vo);
}
