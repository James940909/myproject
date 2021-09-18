package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBCP;


public class MessageDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<MsgSet> selectAll(String userid, int cnt){
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>();
		conn = DBCP.connect();
		String sql;
		try {
			if((userid == null) || (userid.equals(""))) {
				sql = "select * from message where rownum<=? order by mid desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cnt);
			}
			
			else {
				sql = "select * from message where userid=? and rownum <= ? order by mid desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setInt(2, cnt);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MsgSet ms = new MsgSet();
				MessageVO m = new MessageVO();
				ArrayList<ReplyVO> rlist = new ArrayList<ReplyVO>();
				
				m.setMid(rs.getInt("mid"));
				m.setMsg(rs.getString("msg"));
				m.setFavcount(rs.getInt("favcount"));
				m.setUserid(rs.getString("userid"));
				
				String rsql = "select * from reply where mid=? order by rid desc";
				pstmt = conn.prepareStatement(rsql);
				pstmt.setInt(1, rs.getInt("mid"));
				ResultSet rrs = pstmt.executeQuery();
				int rcnt=0;
				while(rrs.next()) {
					ReplyVO r = new ReplyVO();
					r.setMid(rrs.getInt("mid"));
					r.setRid(rrs.getInt("rid"));
					r.setRmsg(rrs.getString("rmsg"));
					r.setUserid(rrs.getString("userid"));
					rlist.add(r);
					rcnt++;
				}
				
				m.setReplycount(rcnt);
				
				ms.setM(m);
				ms.setRlist(rlist);
				datas.add(ms);
				rrs.close();
				
			}
			
			
			
		}
		catch(Exception e) {
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
	
	public boolean insert(MessageVO vo) {
		conn = DBCP.connect();
		String sql = "insert into message(mid, userid, msg) values((SELECT NVL(MAX(mid),0)+1 FROM message),?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getMsg());
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
	public boolean delete(MessageVO vo) {
		conn = DBCP.connect();
		String sql = "delete from message where mid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
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
	public boolean update(MessageVO vo) {
		conn = DBCP.connect();
		String sql = "update message set favcount=favcount+1 where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
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
	
	/*
	public boolean transCU(MessageVO vo) {
		conn = DBCP.connect();
		try {
			conn.setAutoCommit(false); // set autocommit=0;
			String sql1="insert into message(mid, userid, msg) values((SELECT NVL(MAX(mid),0)+1 FROM message),?,?)";
			String sql2="update message set userid=?, msg=? where mid=?";
			pstmt=conn.prepareStatement(sql1); //
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getMsg());
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql2); //
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getMsg());
			pstmt.setInt(3, vo.getMid());
			pstmt.executeUpdate();
			ResultSet rs=pstmt.executeQuery();
			
			rs.next();
			if(rs.getInt(1)<0) { // 잔액이 0미만이면,
				conn.rollback();
				return false; 
			}
			else {
				conn.commit(); // commit;
			}
			
			conn.setAutoCommit(true); // set autocommit=0;	
			
		}
		catch (Exception e) {
			System.out.println("transCU()에서 예외발생!");
			e.printStackTrace();
		} 
		
		finally {
			try {
				rs.close();
			}
			catch (SQLException e) {
				System.out.println("transCU()에서 예외발생!");
				e.printStackTrace();
			}
			DBCP.disconnect(pstmt, conn);
		}
				
		return true;
	}
	*/
	
}
