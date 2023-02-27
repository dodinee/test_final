package com.zerock.myapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zerock.myapp.JDBCConnect;
import com.zerock.myapp.entity.SanInfo;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SanInfoService{

	
	private DataSource db;

	
	public SanInfoService() throws NamingException {
		

			Context ctx = new InitialContext();

			Object obj = ctx.lookup("java:comp/env/jdbc/OracleCloudATPWithDriverSpy");

			Objects.requireNonNull(obj);
			this.db = (DataSource) obj;
		
	}// default constructor
	
	
	public SanInfo getInfo(int id) throws ClassNotFoundException {
		
		
		String sql = "SELECT * FROM san_info_V WHERE info_cd=?";
		SanInfo san = new SanInfo();

		try {
			
			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			@Cleanup
			ResultSet rs = st.executeQuery();
			rs.next();

			san.setSanInfoCd(id);
			san.setName(rs.getString("san_name"));
			san.setHeight(rs.getInt("height"));
			san.setAddress(rs.getString("address"));
			san.setReason(rs.getString("reason"));
			san.setOverview(rs.getString("overview"));
			san.setDetails(rs.getString("details"));
			san.setLat(rs.getDouble("lat"));
			san.setLon(rs.getDouble("lon"));
			san.setImg(rs.getString("img"));
			
			log.info(san);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return san;
	}
	
	//-------------------------------------------------------
	public LinkedBlockingDeque<SanInfo> getInfoList() {

		return getInfoList("san_name", "", 1);
	}

	public LinkedBlockingDeque<SanInfo> getInfoList(int page) {

		return getInfoList("san_name", "", page);
	}

	public LinkedBlockingDeque<SanInfo> getInfoList(String field, String query, int page) {

		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY LIKE_CNT DESC) num, san_info_V.* FROM SAN_INFO_V WHERE ");
		sql.append("san_name").append(" LIKE ?) WHERE num BETWEEN ? AND ?");
		

		LinkedBlockingDeque<SanInfo> list = new LinkedBlockingDeque<>();

		try {

			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			
			pst.setString(1, "%" + query + "%");
			pst.setInt(2, (page - 1) * 50 + 1);
			pst.setInt(3, page * 50);
			
			@Cleanup
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				SanInfo san = new SanInfo();
				
				san.setSanInfoCd(rs.getInt("info_cd"));
				san.setName(rs.getString("san_name"));
				san.setHeight(rs.getInt("height"));
				san.setAddress(rs.getString("address"));
				san.setReason(rs.getString("reason"));
				san.setOverview(rs.getString("overview"));
				san.setDetails(rs.getString("details"));
				san.setLat(rs.getDouble("lat"));
				san.setLon(rs.getDouble("lon"));
				san.setImg(rs.getString("img"));

				list.add(san);
			} // while

			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return list;
	}
}
