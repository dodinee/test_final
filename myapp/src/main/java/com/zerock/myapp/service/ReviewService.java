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

import com.zerock.myapp.entity.SanReview;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReviewService {

	private DataSource db;

	public ReviewService() throws NamingException {

		Context ctx = new InitialContext();

		Object obj = ctx.lookup("java:comp/env/jdbc/OracleCloudATPWithDriverSpy");

		Objects.requireNonNull(obj);
		this.db = (DataSource) obj;

	}// default constructor

	public SanReview getReview(int sanReviewCd) throws ClassNotFoundException {

//		JDBCConnect db = new JDBCConnect();
		String sql = "SELECT * FROM san_review_v WHERE review_cd=?";
		SanReview review = new SanReview();

		try {

			@Cleanup
			Connection con = this.db.getConnection();

			@Cleanup
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, sanReviewCd);

			@Cleanup
			ResultSet rs = st.executeQuery();
			rs.next();

			review.setSanReviewCd(sanReviewCd);
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

	// -------------------------------------------------------

	public LinkedBlockingDeque<SanReview> getReviewList() {

		return getReviewList("title", "", 1);
	}

	public LinkedBlockingDeque<SanReview> getReviewList(int page) {

		return getReviewList("title", "", page);
	}

	public LinkedBlockingDeque<SanReview> getReviewList(String field, String query, int page) {

		StringBuffer sql = new StringBuffer();

		sql.append(
				"SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY created_dt DESC) num, SAN_REVIEW_V.* FROM SAN_REVIEW_V WHERE ");
		sql.append(field).append(" LIKE ?) WHERE num BETWEEN ? AND ?");

		LinkedBlockingDeque<SanReview> list = new LinkedBlockingDeque<>();

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

		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return list;
	}

	
	public void updateReview(int sanReviewCd) throws ClassNotFoundException {

		/* 생각해보니까 얘는 작성폼으로 넘어가서 기존 글 제목이랑 내용을 붙여줘야하는거네 */
		
		String sql = "";

		try {

			@Cleanup
			Connection con = this.db.getConnection();

			@Cleanup
			PreparedStatement st = con.prepareStatement(sql);

			@Cleanup
			ResultSet rs = st.executeQuery();

//			review.setSanReviewCd(id);
//			review.setSanName(rs.getString("san_name"));
//			review.setNickname(rs.getString("nick_name"));
//			review.setUserPic(rs.getString("user_pic"));
//			review.setCreatedDt(rs.getTimestamp("created_dt"));
//			review.setTitle(rs.getString("title"));
//			review.setContents(rs.getString("contents"));
//			review.setLikeCnt(rs.getInt("like_cnt"));


		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return;
	}

	public void deleteReview(int sanReviewCd) throws ClassNotFoundException {
		
		
		StringBuffer sql = new StringBuffer();

		sql.append("DELETE SAN_REVIEW_TB WHERE san_review_cd = ?");

		try {

			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			
			pst.setInt(1, sanReviewCd);

			pst.executeUpdate();

		} catch (

		SQLException e) {
			e.printStackTrace();
		} // try-catch
	}
	
}