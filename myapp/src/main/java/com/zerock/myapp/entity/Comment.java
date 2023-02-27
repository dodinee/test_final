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
	// 블라인드 처리가 아예 노출 제외인지, 블라인드 처리된 댓글입니다. 인지
	// 후자라면 신고수를 가지고 있어야 할 것 같은데 
	// 전자라면 쿼리에서댓글 가져올때 제외시켜야 되는건가?
}// end class
