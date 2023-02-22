package com.zerock.myapp.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zerock.myapp.JDBCConnect;
import com.zerock.myapp.entity.SanInfo;
import com.zerock.myapp.entity.SanReview;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SanInfoService{

	
	public SanInfo getInfo(int id) throws ClassNotFoundException {
		
		
		JDBCConnect db = new JDBCConnect();
		String sql = "SELECT * FROM san_info_V WHERE info_cd=?";
		SanInfo san = new SanInfo();

		try {
			
			PreparedStatement st = db.con.prepareStatement(sql);
			st.setInt(1, id);
			
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
			
			db.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return san;
	}
	
	//-------------------------------------------------------
	public List<SanInfo> getInfoList() {

		return getInfoList("san_name", "", 1);
	}

	public List<SanInfo> getInfoList(int page) {

		return getInfoList("san_name", "", page);
	}

	public List<SanInfo> getInfoList(String field, String query, int page) {

		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY LIKE_CNT DESC) num, san_info_V.* FROM SAN_INFO_V WHERE ");
		sql.append("san_name").append(" LIKE ?) WHERE num BETWEEN ? AND ?");
		

		List<SanInfo> list = new ArrayList<>();

		try {

			JDBCConnect db = new JDBCConnect();
			
			PreparedStatement pst = db.con.prepareStatement(sql.toString());
			
			pst.setString(1, "%" + query + "%");
			pst.setInt(2, (page - 1) * 5 + 1);
			pst.setInt(3, page * 5);
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

			db.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return list;
	}
}
