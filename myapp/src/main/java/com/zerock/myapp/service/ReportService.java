package com.zerock.myapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zerock.myapp.entity.Comment;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReportService {

	private DataSource db;
	
	public ReportService() throws NamingException {

		Context ctx = new InitialContext();

		Object obj = ctx.lookup("java:comp/env/jdbc/OracleCloudATPWithDriverSpy");

		Objects.requireNonNull(obj);
		this.db = (DataSource) obj;
		
	}// default constructor

	public void insertReport(String targetGb, int targetCd, int userCd, String reportGb) {

		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO REPORT_TB (target_gb, target_cd, user_cd, report_gb) ");
		sql.append("VALUES (?, ?, ?, ?)");
		
		try { 

			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			
			pst.setString(1, targetGb);
			pst.setInt(2, targetCd);
			pst.setInt(3, userCd);
			pst.setString(4, reportGb);
			

			pst.executeUpdate();

		} catch (

		SQLException e) {
			e.printStackTrace();
		} // try-catch
	}

}// end class
