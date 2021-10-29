package model.daymeal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class DayMealRowMapper implements RowMapper<DayMealVO>{
	@Override
	public DayMealVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DayMealVO data = new DayMealVO();
		data.setD_num(rs.getInt("d_num"));
		data.setD_name(rs.getString("d_name"));
		data.setD_date(rs.getString("d_date"));
		data.setD_category(rs.getString("d_category"));
		data.setD_daykcal(rs.getDouble("d_daykcal"));
		data.setD_userskcal(rs.getDouble("d_userskcal"));
		data.setD_users(rs.getInt("d_users"));
		return data;
	}
}

@Repository
public class DayMealDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String sql_SELECT_ALL = "SELECT * FROM daymeal ORDER BY d_num ASC";
	private static String sql_SELECT_ONE = "SELECT * FROM daymeal WHERE d_num=?";
	private static String sql_INSERT = "INSERT INTO daymeal (d_num, d_date, d_name, d_category, d_daykcal, d_userskcal, d_users) VALUES ((SELECT nvl(max(d_num),0)+1 from daymeal),sysdate,?,?,?,?,?)";
	private static String sql_DELETE = "DELETE daymeal WHERE d_num=?";
	private static String sql_UPDATE = "UPDATE daymeal SET d_name=?, d_weight=?, m_unit=?, m_kcal=? WHERE m_num=?";
	

	
	public void insertDayMeal(DayMealVO vo) {
		System.out.println("jdbcTemplate-insertDayMeal");
		Object[] args = { vo.getD_name(), vo.getD_category(), vo.getD_daykcal(), vo.getD_userskcal(), vo.getD_users() };
		jdbcTemplate.update(sql_INSERT, args);
	}
	public void deleteDayMeal(DayMealVO vo) {
		System.out.println("jdbcTemplate-deleteDayMeal");
		jdbcTemplate.update(sql_DELETE, vo.getD_num());
	}
	public void updateDayMeal(DayMealVO vo) {
		System.out.println("jdbcTemplate-updateDayMeal");
		jdbcTemplate.update(sql_UPDATE);
	}
	public List<DayMealVO> selectAllDayMeal(DayMealVO vo) {
		System.out.println("jdbcTemplate-selectAllDayMeal");
		return jdbcTemplate.query(sql_SELECT_ALL, new DayMealRowMapper());
	}
	public DayMealVO selectOneDayMeal(DayMealVO vo) {
		System.out.println("jdbcTemplate-selectOneDayMeal");
		Object[] args = { vo.getD_num() };
		return jdbcTemplate.queryForObject(sql_SELECT_ONE, args, new DayMealRowMapper());
	}
	
	
}
