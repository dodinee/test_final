package com.zerock.myapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SanInfo {

	private int sanInfoCd;
	private String name;
	private int height;
	private String address;
	private String reason;
	private String overview;
	private String details;
	private double lat;
	private double lon;
	private String img;
	private int likeCnt;
	
	
}// end class
