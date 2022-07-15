package com.pj.cherrypick.domain;

import java.util.Date;

import lombok.Data;


@Data // @Setter, @Getter 등 사용가능
public class BoardVO {
	
	/*tbl_board 생성문*/
//	CREATE TABLE `tbl_board`(
//		`bno` INT NOT NULL auto_increment,
//		`title` VARCHAR(50) NOT null, 
//		`content` text NOT null,
//		`writer` VARCHAR(30) NOT NULL,
//		`regDate` timestamp DEFAULT NOW(), 
//		`viewCnt` int DEFAULT 0, 
//		PRIMARY KEY (`bno`)
//	);
	
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate; // java.util.Date
	private int viewCnt;
	
}
