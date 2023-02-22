package com.zerock.myapp.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zerock.myapp.JDBCConnect;
import com.zerock.myapp.entity.SanParty;
import com.zerock.myapp.entity.SanReview;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PartyService{

	
	public SanParty getParty(int id) throws ClassNotFoundException {
		
		
		JDBCConnect db = new JDBCConnect();
		String sql = "SELECT * FROM san_party_v WHERE san_party_cd=?";
		SanParty party = new SanParty();

		try {
			
			PreparedStatement st = db.con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			rs.next();

			party.setSanPartyCd(id);
			party.setSanName(rs.getString("san_name"));
			party.setNickname(rs.getString("nick_name"));
			party.setUserPic(rs.getString("user_pic"));
			party.setCreatedDt(rs.getTimestamp("created_dt"));
			party.setTitle(rs.getString("title"));
			party.setContents(rs.getString("contents"));
			party.setPartyYmd(rs.getTimestamp("party_ymd"));
			party.setPartyTime(rs.getTimestamp("party_time"));
			party.setPartyMax(rs.getInt("party_max"));
			party.setItems(rs.getString("items"));
			party.setCondition(rs.getString("condition"));
			party.setLikeCnt(rs.getInt("like_cnt"));
			party.setUserCnt(rs.getInt("user_cnt"));
			
			
			log.info(party);
			
			db.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return party;
	}
	
	//-------------------------------------------------------
	public List<SanParty> getPartyList() {

		return getPartyList("title", "", 1);
	}

	public List<SanParty> getPartyList(int page) {

		return getPartyList("title", "", page);
	}

	public List<SanParty> getPartyList(String field, String query, int page) {

		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY created_dt DESC) num, san_party_v.* FROM san_party_v WHERE ");
		sql.append(field).append(" LIKE ?) WHERE num BETWEEN ? AND ?");
		

		List<SanParty> list = new ArrayList<>();

		try {

			JDBCConnect db = new JDBCConnect();
			
			PreparedStatement pst = db.con.prepareStatement(sql.toString());
			
			pst.setString(1, "%" + query + "%");
			pst.setInt(2, (page - 1) * 5 + 1);
			pst.setInt(3, page * 5);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				SanParty party = new SanParty();
				
				party.setSanPartyCd(rs.getInt("party_cd"));
				party.setSanName(rs.getString("san_name"));
				party.setNickname(rs.getString("nick_name"));
				party.setUserPic(rs.getString("user_pic"));
				party.setCreatedDt(rs.getTimestamp("created_dt"));
				party.setTitle(rs.getString("title"));
				party.setContents(rs.getString("contents"));
				party.setPartyYmd(rs.getTimestamp("party_ymd"));
				party.setPartyTime(rs.getTimestamp("party_time"));
				party.setPartyMax(rs.getInt("party_max"));
				party.setItems(rs.getString("items"));
				party.setCondition(rs.getString("condition"));
				party.setLikeCnt(rs.getInt("like_cnt"));
				party.setUserCnt(rs.getInt("user_cnt"));
				
				list.add(party);
			} // while

			db.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return list;
	}
}
