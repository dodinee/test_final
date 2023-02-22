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
public class SanParty {
	
	private int sanPartyCd;
	private String sanName;
	private String nickname;
	private String userPic;
	private Timestamp createdDt;
	private String title;
	private String contents;
	private Timestamp partyYmd;
	private Timestamp partyTime;
	private int partyMax;
	private String items;
	private String Condition;
	private	int likeCnt;
	private int UserCnt;

}// end class
