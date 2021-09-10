package model.bank1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.common.JDBC;
import model.bank1.Bank1VO;



public class Bank1DAO {
	
	public ArrayList<Bank1VO> getBank1List(){
		Connection conn = JDBC.connect();
		ArrayList<Bank1VO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "select * from bank1";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Bank1VO vo = new Bank1VO();
				vo.setName(rs.getString("name"));
				vo.setMoney(rs.getInt("money"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getBank1List()에서 예외발생!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	
	public boolean trans(Bank1VO vo, Bank1VO vo1) {
		Connection conn = JDBC.connect();
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false); // set autocommit=0;
			String sql1="update bank1 set money=money-? where name=?";
			String sql2="update bank1 set money=money+? where name=?";
			pstmt=conn.prepareStatement(sql1); // 돈뺴기
			pstmt.setInt(1, vo1.getMoney());
			pstmt.setString(2, vo.getName());
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql2); // 돈넣기
			pstmt.setInt(1, vo1.getMoney());
			pstmt.setString(2, vo1.getName());
			pstmt.executeUpdate();
			String sql3="select money from bank1 where name=?";
			pstmt=conn.prepareStatement(sql3);
			pstmt.setString(1, vo.getName());
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
			System.out.println("trans()에서 예외발생!");
			e.printStackTrace();
		} 
		
		finally {
			JDBC.disconnect(pstmt, conn);
		}
				
		return true;
	}

}
