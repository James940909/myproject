package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;


public class MemberDAO {

	// selectAll
	public ArrayList<MemberVO> getDBList(){
		Connection conn = JDBC.connect();
		ArrayList<MemberVO> datas = new ArrayList();
		PreparedStatement pstmt = null;

		try {
			String sql = "select * from member order by mnum"; // 최근 게시글 상단 배치
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMnum(rs.getInt("mnum"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				datas.add(vo);
			}
			rs.close();
		}

		catch(Exception e) {
			System.out.println("getDBList()에서 출력됨!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}

	// selectOne
	public MemberVO login(MemberVO vo) {
		Connection conn=JDBC.connect();
		MemberVO data=null;
		PreparedStatement pstmt=null;
		try{
			String sql="select * from member where id=? and pw=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new MemberVO();
				data.setMnum(rs.getInt("mnum"));
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
			}
			
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBData()에서 출력됨!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return data;
	}
	
	// INSERT
	public boolean insertDB(MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res = false;
		PreparedStatement pstmt=null;
		try{
			String sql="INSERT INTO member (mnum, id, pw) VALUES((SELECT NVL(MAX(mnum),0) + 1 FROM member), ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertDB()에서 출력됨!");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

	public boolean deleteDB(MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="delete from member where mnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("deleteDB()에서 출력됨!");
			e.printStackTrace();
			
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

	// update
	public boolean updateDB(MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="update member set id=?, pw=? where mnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setInt(3, vo.getMnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("updateDB()에서 출력됨!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}


}