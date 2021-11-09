package model.totalmeal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;




class TotalMealRowMapper implements RowMapper<TotalMealVO>{
	@Override
	public TotalMealVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TotalMealVO data = new TotalMealVO();
		data.setT_num(rs.getInt("t_num"));
		data.setT_date(rs.getDate("t_date"));
		data.setT_users(rs.getString("t_users"));
		data.setT_daykcal(rs.getDouble("t_daykcal"));
		data.setT_userskcal(rs.getDouble("t_userskcal"));
		data.setT_ox(rs.getString("t_ox"));
		return data;
	}
}

@Repository
public class TotalMealDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String sql_SELECT_ALL = "SELECT * FROM totalmeal WHERE t_num=? ORDER BY t_date DESC";
	private static String sql_INSERT = "INSERT INTO totalmeal (t_num, t_date, t_users, t_daykcal, t_userskcal, t_ox) "
			+ "VALUES (?, sysdate, ?, ?, ?, ?)";
	
	public List<TotalMealVO> selectAllTotalMeal(TotalMealVO vo) {
		Object[] args = { vo.getT_num() };
		return jdbcTemplate.query(sql_SELECT_ALL, args, new TotalMealRowMapper());
	}
	
	public void insertTotalMeal(TotalMealVO vo) {
		Object[] args = { vo.getT_num(), vo.getT_users(), vo.getT_daykcal(), vo.getT_userskcal(), vo.getT_ox() };
		jdbcTemplate.update(sql_INSERT, args);
	}
}
