package model.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class UsersRowMapper implements RowMapper<UsersVO>{

	@Override
	public UsersVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsersVO data=new UsersVO();
		data.setU_num(rs.getInt("u_num"));
		data.setId(rs.getString("id"));
		data.setPw(rs.getString("pw"));
		data.setU_name(rs.getString("u_name"));
		data.setU_gender(rs.getString("u_gender"));
		data.setU_height(rs.getDouble("u_height"));
		data.setU_weight(rs.getDouble("u_weight"));
		data.setSuccessCnt(rs.getInt("successCnt"));
		data.setU_profile(rs.getString("u_profile"));
		
		
		return data;
	}

	
	
	
}

@Repository
public class UsersDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String sql_SELECT_ALL = "SELECT * FROM users ORDER BY u_num DESC";
	private static String sql_SELECT_ONE = "SELECT * FROM users WHERE id=? AND pw=?";
	private static String sql_INSERT = "INSERT INTO users"
			+ "(u_num, id, pw, u_name, u_gender, u_height, u_weight, successCnt, u_profile)"
			+ "VALUES ((SELECT nvl(max(u_num),0)+1 from users),?,?,?,?,?,?,?,?)";
	private static String sql_DELETE = "DELETE users WHERE u_num=?";
	private static String sql_UPDATE = "UPDATE users SET pw=?, u_name=?, u_weight=?, successCnt=? WHERE u_num=?";
	
	public void insertUsers(UsersVO vo) {
		System.out.println("jdbcTemplate-insertUsers");
		jdbcTemplate.update(sql_INSERT, vo.getId(), vo.getPw(), vo.getU_name(), vo.getU_gender(), vo.getU_height(),
										vo.getU_weight(), vo.getSuccessCnt(), vo.getU_profile());
	}
	
	public void deleteUsers(UsersVO vo) {
		System.out.println("jdbcTemplate-deleteUsers");
		jdbcTemplate.update(sql_DELETE, vo.getU_num());
	}
	
	public void updateUsers(UsersVO vo) {
		System.out.println("jdbcTemplate-updateUsers");
		jdbcTemplate.update(sql_UPDATE, vo.getPw(), vo.getU_name(), vo.getU_weight(), vo.getSuccessCnt(), vo.getU_num());
	}
	
	public List<UsersVO> selectAllUsers(UsersVO vo){
		System.out.println("jdbcTemplate-selectAllUsers");
		return jdbcTemplate.query(sql_SELECT_ALL, new UsersRowMapper());
	}
	public UsersVO selectOneUsers(UsersVO vo){
		System.out.println("jdbcTemplate-selectOneUsers");
		Object[] args= { vo.getId(), vo.getPw() };
		return jdbcTemplate.queryForObject(sql_SELECT_ONE, args, new UsersRowMapper());
	}

}
