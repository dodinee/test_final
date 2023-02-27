package com.zerock.myapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zerock.myapp.JDBCConnect;
import com.zerock.myapp.entity.Comment;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommentService {

	private DataSource db;
	
	public CommentService() throws NamingException {

		Context ctx = new InitialContext();

		Object obj = ctx.lookup("java:comp/env/jdbc/OracleCloudATPWithDriverSpy");

		Objects.requireNonNull(obj);
		this.db = (DataSource) obj;
		
	}// default constructor

	public LinkedBlockingDeque<Comment> getComments(String targetGb, int targetCd) {

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM COMMENT_V WHERE target_gb = ? AND target_cd = ? AND mention_cd IS NULL ORDER BY comment_cd ASC");

//		List<Comment> list = new ArrayList<>(); // 쓰레기 
//		Deque<Comment> deq = new ArrayDeque<>();
		LinkedBlockingDeque <Comment> deq = new LinkedBlockingDeque<>();

		try {
			
			@Cleanup
			Connection con = this.db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, targetGb);
			pst.setInt(2, targetCd);

			log.info(sql);
			
			@Cleanup
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Comment comment = new Comment();

				comment.setCommentCd(rs.getInt("COMMENT_CD"));
				comment.setTargetGb(rs.getString("TARGET_GB"));
				comment.setTargetCd(rs.getInt("TARGET_CD"));
				comment.setNickname(rs.getString("NICKNAME"));
				comment.setUserPic(rs.getString("USER_PIC"));
				comment.setCreatedDt(rs.getTimestamp("CREATED_DT"));
				comment.setContents(rs.getString("CONTENTS"));
				
				deq.add(comment);
				
				LinkedBlockingDeque<Comment> mention = this.getMentions(comment.getCommentCd());
				
				for(Comment m : mention) {
					deq.add(m);
				}// for
				
			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return deq;
	}

	public LinkedBlockingDeque<Comment> getMentions(int mentionCd) {
		
		// 지금 코드는 엄마댓글이 불러와져야 멘션들이 불러와지는 상태라 
		// 엄마댓글 지워지면 자식들 다 안불러와짐 이게 맞는지? 
		// 그렇다면 엄마댓글 지울 때 자식들도 지워지게 해야 함 지금은 존재하는데 조회가 안되는 상태 
		
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM COMMENT_V WHERE mention_cd = ? ORDER BY mention_cd, comment_cd");

		LinkedBlockingDeque<Comment> deq = new LinkedBlockingDeque<>();
		
		try {

			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, mentionCd);
			
			@Cleanup
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Comment comment = new Comment();

				comment.setCommentCd(rs.getInt("COMMENT_CD"));
				comment.setTargetGb(rs.getString("TARGET_GB"));
				comment.setTargetCd(rs.getInt("TARGET_CD"));
				comment.setMentionCd(rs.getInt("MENTION_CD"));
				comment.setNickname(rs.getString("NICKNAME"));
				comment.setUserPic(rs.getString("USER_PIC"));
				comment.setCreatedDt(rs.getTimestamp("CREATED_DT"));
				comment.setContents(rs.getString("CONTENTS"));

				deq.add(comment);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch

		return deq;
	}

	public void insertComment(String targetGb, int targetCd, int userCd, String contents) {

		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO COMMENT_TB (target_gb, target_cd, user_cd, contents) ");
		sql.append("VALUES (?, ?, ?, ?)");
		
		try { 

			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			
			pst.setString(1, targetGb);
			pst.setInt(2, targetCd);
			pst.setInt(3, userCd);
			
			contents.replaceAll("\r\n", "<br>");
			pst.setString(4, contents);

			pst.executeUpdate();

		} catch (

		SQLException e) {
			e.printStackTrace();
		} // try-catch
	}
	
	public void insertMention(String targetGb, int targetCd, int userCd, String contents, int mentionCd) {

		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO COMMENT_TB (target_gb, target_cd, user_cd, contents, mention_cd) ");
		sql.append("VALUES (?, ?, ?, ?, ?)");

		try {

			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			
			pst.setString(1, targetGb);
			pst.setInt(2, targetCd);
			pst.setInt(3, userCd);
			pst.setString(4, contents);
			pst.setInt(5, mentionCd);

			pst.executeUpdate();

		} catch (

		SQLException e) {
			e.printStackTrace();
		} // try-catch
	}

	public void deleteComment(int commentCd) {

		StringBuffer sql = new StringBuffer();

		sql.append("DELETE FROM COMMENT_TB WHERE comment_cd = ?");

		try {

			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			
			pst.setInt(1, commentCd);

			pst.executeUpdate();

		} catch (

		SQLException e) {
			e.printStackTrace();
		} // try-catch
	}
	
	public void reportComment(int commentCd, int userCd, String reportGb) {
		
		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO REPORT_TB (target_gb, target_cd, user_cd, report_gb) ");
		sql.append("VALUES (?, ?, ?, ?)");

		try {

			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			
			pst.setString(1, "COMMENT");
			pst.setInt(2, commentCd);
			pst.setInt(3, userCd);
			pst.setString(4, reportGb);

			pst.executeUpdate();

		} catch (

		SQLException e) {
			e.printStackTrace();
		} // try-catch
	}

	public void updateComment(int commentCd, String contents) {
		
		StringBuffer sql = new StringBuffer();

		sql.append("UPDATE COMMENT_TB SET contents = ?, created_dt = systimestamp WHERE comment_cd = ?");

		try {

			@Cleanup
			Connection con = db.getConnection();
			
			@Cleanup
			PreparedStatement pst = con.prepareStatement(sql.toString());
			
			pst.setString(1, contents);
//			pst.setString(2, "CREATED_DT");
			pst.setInt(2, commentCd);

			pst.executeUpdate();

		} catch (

		SQLException e) {
			e.printStackTrace();
		} // try-catch
	}
}// end class
