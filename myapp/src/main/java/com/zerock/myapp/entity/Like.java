package com.zerock.myapp.entity;

import lombok.Data;


@Data
public class Like {

	private String targetGb;
	private int targetCd;
	private int userCd;
	private String status;
}// end class
