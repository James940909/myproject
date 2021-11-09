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
		try {
			return dayMealDAO.selectAllDayMeal(vo);
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public DayMealVO getDayMeal(DayMealVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DayMealVO> morningDayMealList(DayMealVO vo) {
		try {
			return dayMealDAO.morningDayMeal(vo);
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public List<DayMealVO> lunchDayMealList(DayMealVO vo) {
		try {
			return dayMealDAO.lunchDayMeal(vo);
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public List<DayMealVO> dinnerDayMealList(DayMealVO vo) {
		try {
			return dayMealDAO.dinnerDayMeal(vo);
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public List<DayMealVO> otherDayMealList(DayMealVO vo) {
		try {
			return dayMealDAO.otherDayMeal(vo);
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public void allDelete(DayMealVO vo) {
		dayMealDAO.allDelete(vo);
	}

}
