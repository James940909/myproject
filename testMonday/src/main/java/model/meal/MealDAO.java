package model.meal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;




class MealRowMapper implements RowMapper<MealVO>{
	@Override
	public MealVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MealVO data = new MealVO();
		data.setM_num(rs.getInt("m_num"));
		data.setM_name(rs.getString("m_name"));
		data.setM_weight(rs.getDouble("m_weight"));
		data.setM_unit(rs.getString("m_unit"));
		data.setM_kcal(rs.getDouble("m_kcal"));
		
		return data;
	}
}

@Repository
public class MealDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String sql_SELECT_ALL = "SELECT * FROM meal ORDER BY m_num ASC";
	private static String sql_SELECT_ONE = "SELECT * FROM meal WHERE m_num=?";
	private static String sql_INSERT = "INSERT INTO meal (m_num, m_name, m_weight, m_unit, m_kcal)"
			+ "VALUES ((SELECT nvl(max(m_num),0)+1 from meal),?,?,?,?)";
	private static String sql_DELETE = "DELETE meal WHERE m_num=?";
	private static String sql_UPDATE = "UPDATE meal SET m_name=?, m_weight=?, m_unit=?, m_kcal=? WHERE m_num=?";
	
	private static String sql_SEARCHKCAL = "SELECT * FROM meal WHERE m_name=?";
	
	public void insertMeal(MealVO vo) {
		System.out.println("jdbcTemplate-insertMeal");
		jdbcTemplate.update(sql_INSERT, vo.getM_name(), vo.getM_weight(), vo.getM_unit(), vo.getM_kcal());
	}
	public void deleteMeal(MealVO vo) {
		System.out.println("jdbcTemplate-deleteMeal");
		jdbcTemplate.update(sql_DELETE, vo.getM_num());
	}
	public void updateMeal(MealVO vo) {
		System.out.println("jdbcTemplate-updateMeal");
		jdbcTemplate.update(sql_UPDATE, vo.getM_name(), vo.getM_weight(), vo.getM_unit(), vo.getM_kcal(), vo.getM_num());
	}
	public List<MealVO> selectAllMeal(MealVO vo){
		System.out.println("jdbcTemplate-selectAllMeal");
		return jdbcTemplate.query(sql_SELECT_ALL, new MealRowMapper());
	}
	public MealVO selectOneMeal(MealVO vo){
		System.out.println("jdbcTemplate-selectOneMeal");
		Object[] args = { vo.getM_num() };
		return jdbcTemplate.queryForObject(sql_SELECT_ONE, args, new MealRowMapper());
	}
	
	public MealVO searchKcal(MealVO vo) {
		System.out.println("jdbcTemplate-searchKcal");
		Object[] args = { vo.getM_name() };
		return jdbcTemplate.queryForObject(sql_SEARCHKCAL, args, new MealRowMapper());
	}

}
