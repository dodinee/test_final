package com.zerock.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCConnect {
	
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBCConnect() {
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:log4jdbc:oracle:thin:@wegodb1_high?TNS_ADMIN=/Users/sowls/wallet/Wallet_wegodb1";
			String id = "admin";
			String pwd = "Wego12345678";
			
			con = DriverManager.getConnection(url, id, pwd);
			
			log.info("jdbc연결 성공(basic)");
			
		}catch(Exception e) {
			e.printStackTrace();
		}// try-catch
	}// constructor
	
	public void close() {
		
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(con != null) con.close();
			
			log.info("close() invoked.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}// try-catch
	}// close
	
}// end class
