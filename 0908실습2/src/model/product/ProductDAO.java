package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;




public class ProductDAO {
	
	private static String sql_SearchProduct = "SELECT * from product WHERE ? like %?%";
	
	public ArrayList<ProductVO> getProductList(){
		Connection conn = JDBC.connect();
		ArrayList<ProductVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "select * from product";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getProductList()에서 예외발생!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public ArrayList<ProductVO> searchProduct(String condition,String content){
		Connection conn = JDBC.connect();
		ArrayList<ProductVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		
		try {
			//String sql = "select * from product where "+condition+" like '%"+content+"%'";
			pstmt = conn.prepareStatement(sql_SearchProduct);
			pstmt.setString(1, condition);
			pstmt.setString(2, content);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("searchProduct()에서 예외발생!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	// selectOne
	public ProductVO getProduct(ProductVO vo) {
		Connection conn=JDBC.connect();
		ProductVO data=null;
		PreparedStatement pstmt=null;
		try{
			String sql="select * from product where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new ProductVO();
				data.setName(rs.getString("name"));
				data.setPrice(rs.getInt("price"));
				
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getProduct()에서 예외발생!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return data;
	}
	
	
	public boolean insertProduct(ProductVO vo) {
		Connection conn=JDBC.connect();
		boolean res = false;
		PreparedStatement pstmt=null;
		try{
			String sql="INSERT INTO product VALUES (?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertProduct()에서 예외발생!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	public boolean deleteProduct(ProductVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="delete from product where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("deleteProduct()에서 예외발생!");
			e.printStackTrace();
			
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	public boolean updateProduct(ProductVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="update product set name=?, price=? where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("updateProduct()에서 예외발생!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

}
