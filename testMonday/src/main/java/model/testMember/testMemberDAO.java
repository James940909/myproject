package model.testMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.common.DBCP;
import model.testMember.testMemberVO;


public class testMemberDAO {
	
	private static String sql_INSERT = "INSERT INTO testMember (id, pw, name) VALUES(?, ?, ?)";
	private static String sql_SELECTONE="SELECT * FROM testMember WHERE id=? and pw=?";
	
	public testMemberVO SelectOne(testMemberVO vo) {
		Connection conn=DBCP.connect();
		testMemberVO data=null;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_SELECTONE);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new testMemberVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("testMemberDAO SelectOne() printed!");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return data;
	}
	
	public boolean insertMember(testMemberVO vo) {
		Connection conn=DBCP.connect();
		boolean res = false;
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			res=true;
		}
		catch (Exception e) {
			System.out.println("testMemberDAO insertMember()에서 출력");
			e.printStackTrace();
			
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return res;
	}

}
