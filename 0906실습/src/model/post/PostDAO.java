package model.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;


public class PostDAO {
	
	
	public ArrayList<PostVO> myListAll(PostVO vo){
		Connection conn=JDBC.connect();
		ArrayList<PostVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		
		try {
			String sql="select * from post where member=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMember());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				PostVO data=new PostVO();
				data.setPnum(rs.getInt("pnum"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
			rs.close();
			
		}
		catch(Exception e){
			System.out.println("myListAll()¿¡¼­ Ãâ·ÂµÊ!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		
		return datas;
	}
	
	
	public ArrayList<PostVO> searchAll(String condition,String content){
		Connection conn=JDBC.connect();
		ArrayList<PostVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try {
			String sql="select * from post where "+condition+" like '%"+content+"%' order by pnum desc";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				PostVO data=new PostVO();
				data.setPnum(rs.getInt("pnum"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("searchAll()¿¡¼­ Ãâ·ÂµÊ!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		
		return datas;
	}
	
	public ArrayList<PostVO> getDBList(){
		Connection conn=JDBC.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt=null;
		
		try {
			String sql="select * from post order by pnum desc";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				PostVO data= new PostVO();
				data.setMember(rs.getInt("member"));
				data.setPnum(rs.getInt("pnum"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
			rs.close();
			
		}
		catch(Exception e) {
			System.out.println("getDBList()¿¡¼­ Ãâ·ÂµÊ!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public PostVO getDBData(PostVO vo) {
		Connection conn=JDBC.connect();
		PostVO data = null;
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from post where pnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPnum());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data=new PostVO();
				data.setPnum(rs.getInt("pnum"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				data.setMember(rs.getInt("member"));
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("getDBData()¿¡¼­ Ãâ·ÂµÊ!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insertDB(PostVO vo) {
		Connection conn=JDBC.connect();
		boolean res = false;
		PreparedStatement pstmt=null;
		try{
			String sql="insert into post (pnum, writer, title, content, member, wdate) values((select NVL(MAX(pnum),0) + 1 from post), ?, ?, ?, ?, sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4,  vo.getMember());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertDB()¿¡¼­ Ãâ·ÂµÊ!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	public boolean deleteDB(PostVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="delete from post where pnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("deleteDB()¿¡¼­ Ãâ·ÂµÊ!");
			e.printStackTrace();
			
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	public boolean updateDB(PostVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="update post set writer=?, title=?, content=?, member=?, wdate=sysdate where pnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4,  vo.getMember());
			pstmt.setInt(5, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("updateDB()¿¡¼­ Ãâ·ÂµÊ!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	
	
	

}
