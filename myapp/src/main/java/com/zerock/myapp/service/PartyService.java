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

import com.zerock.myapp.entity.SanParty;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PartyService{

	private DataSource db;
	
	
	public PartyService() throws NamingException {
	
		Context ctx = new InitialContext();
		
		Object obj = ctx.lookup("java:comp/env/jdbc/OracleCloudATPWithDriverSpy");
		Objects.requireNonNull(obj);
		
		this.db = (DataSource) obj;
	}// default constructor
	
	
	public SanParty getParty(int id) throws ClassNotFoundException {
		
		
		String sql = "SELECT * FROM san_party_v WHERE party_cd=?";
		SanParty party = new SanParty();

		try {
			
			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			@Cleanup
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
//			party.setImg(rs.getString("img"));
			
			log.info(party);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return party;
	}
	
	//-------------------------------------------------------
	public LinkedBlockingDeque<SanParty> getPartyList() {

		return getPartyList("title", "", 1);
	}

	public LinkedBlockingDeque<SanParty> getPartyList(int page) {

		return getPartyList("title", "", page);
	}

	public LinkedBlockingDeque<SanParty> getPartyList(String field, String query, int page) {

		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY created_dt DESC) num, san_party_v.* FROM san_party_v WHERE ");
		sql.append(field).append(" LIKE ?) WHERE num BETWEEN ? AND ?");
		

		LinkedBlockingDeque<SanParty> list = new LinkedBlockingDeque<>();

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

			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return list;
	}
}
