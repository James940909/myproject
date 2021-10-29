package model.meal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl implements MealService{
	
	@Autowired
	MealDAO mealDAO;

	@Override
	public void insertMeal(MealVO vo) {
		mealDAO.insertMeal(vo);
	}

	@Override
	public void updateMeal(MealVO vo) {
		mealDAO.updateMeal(vo);
	}

	@Override
	public void deleteMeal(MealVO vo) {
		mealDAO.deleteMeal(vo);
	}

	@Override
	public List<MealVO> getMealList(MealVO vo) {
		return mealDAO.selectAllMeal(vo);
	}

	@Override
	public MealVO getMeal(MealVO vo) {
		try {
			return mealDAO.selectOneMeal(vo);
		}
		catch(Exception e){
			return null;
		}
		
	}

	@Override
	public MealVO searchKcal(MealVO vo) {
		return mealDAO.searchKcal(vo);
	}

}
