package com.zerock.myapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zerock.myapp.JDBCConnect;
import com.zerock.myapp.entity.SanReview;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReviewService{

	
	private DataSource db;
	
	public ReviewService() throws NamingException {
		
		Context ctx = new InitialContext();
		
		Object obj = ctx.lookup("java:comp/env/jdbc/OracleCloudATPWithDriverSpy");
		
		Objects.requireNonNull(obj);
		this.db = (DataSource)obj;
		
	}// default constructor
	
	
	public SanReview getReview(int id) throws ClassNotFoundException {
		
		
//		JDBCConnect db = new JDBCConnect();
		String sql = "SELECT * FROM san_review_v WHERE review_cd=?";
		SanReview review = new SanReview();

		try {
			
			@Cleanup
			Connection con = this.db.getConnection();
			
			@Cleanup
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			@Cleanup
			ResultSet rs = st.executeQuery();
			rs.next();

			
			review.setSanReviewCd(id);
			review.setSanName(rs.getString("san_name"));
			review.setNickname(rs.getString("nick_name"));
			review.setUserPic(rs.getString("user_pic"));
			review.setCreatedDt(rs.getTimestamp("created_dt"));
			review.setTitle(rs.getString("title"));
			review.setContents(rs.getString("contents"));
			review.setLikeCnt(rs.getInt("like_cnt"));
			
			log.info(review);

			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return review;
	}
	
	//-------------------------------------------------------
	public List<SanReview> getReviewList() {

		return getReviewList("title", "", 1);
	}

	public List<SanReview> getReviewList(int page) {

		return getReviewList("title", "", page);
	}

	public List<SanReview> getReviewList(String field, String query, int page) {

		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY created_dt DESC) num, SAN_REVIEW_V.* FROM SAN_REVIEW_V WHERE ");
		sql.append(field).append(" LIKE ?) WHERE num BETWEEN ? AND ?");
		

		List<SanReview> list = new ArrayList<>();

		try {

			JDBCConnect db = new JDBCConnect();
			
			PreparedStatement pst = db.con.prepareStatement(sql.toString());
			
			pst.setString(1, "%" + query + "%");
			pst.setInt(2, (page - 1) * 5 + 1);
			pst.setInt(3, page * 5);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				SanReview review = new SanReview();
				
				review.setSanReviewCd(rs.getInt("review_cd"));
				review.setSanName(rs.getString("san_name"));
				review.setNickname(rs.getString("nick_name"));
				review.setUserPic(rs.getString("user_pic"));
				review.setCreatedDt(rs.getTimestamp("created_dt"));
				review.setTitle(rs.getString("title"));
				review.setContents(rs.getString("contents"));
				review.setLikeCnt(rs.getInt("like_cnt"));

				list.add(review);
			} // while

			db.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return list;
	}
}
