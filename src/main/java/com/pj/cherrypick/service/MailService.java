package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final String fromEmail = "park2865526@gmail.com";
	
	@Transactional
	public void sendEmail(String email, String tmpPassword) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo(email); // 수신대상
		msg.setFrom(fromEmail);
		msg.setSubject("[CherryPick] 임시 비밀번호 발급"); // 제목
		msg.setText("임시 발급된 비밀번호는 " + tmpPassword + "입니다. 해당 임시 비밀번호로 로그인 후 비밀번호를 변경해주세요."); // 내용
	
		mailSender.send(msg);
		
		System.out.println("send");
	}
}
