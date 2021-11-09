package model.totalmeal;

import java.util.List;

public interface TotalMealService {
	void insertTotalMeal(TotalMealVO vo);
	void updateTotalMeal(TotalMealVO vo);
	void deleteTotalMeal(TotalMealVO vo);
	List<TotalMealVO> getTotalMealList(TotalMealVO vo);
	TotalMealVO getTotalMeal(TotalMealVO vo);
}
