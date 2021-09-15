package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.common.DBCP;

public class ReplyDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	public boolean insert(ReplyVO vo) {
		conn = DBCP.connect();
		String sql = "insert into reply(rid,mid,userid,rmsg) values((SELECT NVL(MAX(rid),0)+1 FROM reply),?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getMid());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getRmsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean delete(ReplyVO vo) {
		conn = DBCP.connect();
		String sql = "delete from reply where rid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return true;	
	}

}
