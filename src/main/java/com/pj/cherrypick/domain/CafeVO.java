package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Builder
public class CafeVO {

	private int cno;
	private String bid;
	private String cname;
	private String c_lap;
	private String c_long;
	private String cimage;
	private String caddress;
	private String cphone;
	private String copen;
	private String cclose;
	private int parking;
	private int pet;
	private int kids;
	private int seats;
	private int smoke;
	private int group;
	private String ctag;
	private String cmenu_img;
	
	
	
	
	
	
}
