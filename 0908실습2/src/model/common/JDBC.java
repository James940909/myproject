package model.common;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.*;
import javax.sql.DataSource;

public class JDBC {
	
	public static Connection connect() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/orcl");
			conn=ds.getConnection();
		}
		catch(Exception e) {
			System.out.println("connect()에서 출력");
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		try {
			pstmt.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println("disconnect()에서 출력");
			e.printStackTrace();
		}
	}

}
