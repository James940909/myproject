package model.daymeal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayMealServiceImpl implements DayMealService{
	
	@Autowired
	DayMealDAO dayMealDAO;

	@Override
	public void insertDayMeal(DayMealVO vo) {
		// TODO Auto-generated method stub
		dayMealDAO.insertDayMeal(vo);
		
	}

	@Override
	public void updateDayMeal(DayMealVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDayMeal(DayMealVO vo) {
		dayMealDAO.deleteDayMeal(vo);
	}

	@Override
	public List<DayMealVO> getDayMealList(DayMealVO vo) {
		return dayMealDAO.selectAllDayMeal(vo);
	}

	@Override
	public DayMealVO getDayMeal(DayMealVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
