package com.zerock.myapp.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanReview {
	
	private int sanReviewCd;
	private String sanName;
	private String nickname;
	private Timestamp createdDt;
	private String title;
	private String contents;
	private String userPic;
	private	int likeCnt;

}// end class
