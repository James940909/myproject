package model.daymeal;

import java.util.List;

public interface DayMealService {
	void insertDayMeal(DayMealVO vo);
	void updateDayMeal(DayMealVO vo);
	void deleteDayMeal(DayMealVO vo);
	List<DayMealVO> getDayMealList(DayMealVO vo);
	DayMealVO getDayMeal(DayMealVO vo);
	List<DayMealVO> morningDayMealList(DayMealVO vo);
	List<DayMealVO> lunchDayMealList(DayMealVO vo);
	List<DayMealVO> dinnerDayMealList(DayMealVO vo);
	List<DayMealVO> otherDayMealList(DayMealVO vo);
	void allDelete(DayMealVO vo);
}
