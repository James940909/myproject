package model.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBCP;

public class UsersDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean insert(UsersVO vo) {
		conn = DBCP.connect();
		String sql = "insert into users(userid,name,passwd) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean login(UsersVO vo) {
		conn= DBCP.connect();
		String sql = "select userid, passwd from users where userid=?";
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getString("passwd").equals(vo.getPasswd())) {
				result=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			DBCP.disconnect(pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<UsersVO> selectAll(){
		ArrayList<UsersVO> datas = new ArrayList<UsersVO>();
		conn = DBCP.connect();
		String sql = "select * from users where rownum <= 3";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UsersVO data = new UsersVO();
				data.setName(rs.getString("name"));
				data.setUserid(rs.getString("userid"));
				data.setPasswd(rs.getString("passwd"));
				datas.add(data);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}

}
