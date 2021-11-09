package model.totalmeal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalMealServiceImpl implements TotalMealService{

	@Autowired
	TotalMealDAO totalMealDAO;
	
	@Override
	public void insertTotalMeal(TotalMealVO vo) {
		totalMealDAO.insertTotalMeal(vo);
	}

	@Override
	public void updateTotalMeal(TotalMealVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTotalMeal(TotalMealVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TotalMealVO> getTotalMealList(TotalMealVO vo) {
		try {
			return totalMealDAO.selectAllTotalMeal(vo);
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public TotalMealVO getTotalMeal(TotalMealVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
