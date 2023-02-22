package com.zerock.myapp.entity;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Comment {

	private int commentCd;
	private String targetGb;
	private int targetCd;
	private int mentionCd;
	private String nickname;
	private String userPic;
	private String contents;
	private Timestamp createdDt;
	
}// end class
