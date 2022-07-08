package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MailVO {
	private String address;
	private String title;
	private String content;
}
