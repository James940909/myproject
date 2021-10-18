package model.testBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.common.DBCP;
import model.testBoard.testBoardVO;;

public class testBoardDAO {

	private static String sql_SELECT_ALL = "SELECT * FROM testBoard";
	private static String sql_SELECT_ONE = "SELECT * FROM testBoard WHERE bnum=?";
	private static String sql_INSERT = "INSERT INTO testBoard (bnum, title, pdate, writer, content) VALUES((SELECT NVL(MAX(bnum),0) + 1 FROM testBoard), ?, sysdate, ?, ?)";

	public ArrayList<testBoardVO> SelectAll(){
		Connection conn = DBCP.connect();
		ArrayList<testBoardVO> datas = new ArrayList();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				testBoardVO vo = new testBoardVO();
				vo.setBnum(rs.getInt("bnum"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setPdate(rs.getDate("pdate"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("testBoardDAO SelectAll()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public testBoardVO SelectOne(testBoardVO vo) {
		Connection conn=DBCP.connect();
		testBoardVO data=null;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getBnum());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new testBoardVO();
				data.setBnum(rs.getInt("bnum"));
				data.setTitle(rs.getString("title"));
				data.setPdate(rs.getDate("pdate"));
				data.setContent(rs.getString("content"));
				data.setWriter(rs.getString("writer"));
				
			}   
			rs.close();
		}
		catch(Exception e){
			System.out.println("testBoardDAO SelectOne()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return data;
	}
	
	public boolean insertBoard(testBoardVO vo) {
		Connection conn=DBCP.connect();
		boolean res = false;
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			res=true;
		}
		catch (Exception e) {
			System.out.println("testBoardDAO insertBoard()에서 출력");
			e.printStackTrace();
			
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return res;
	}

}
