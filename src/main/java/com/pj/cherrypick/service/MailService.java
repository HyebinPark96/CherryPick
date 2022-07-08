package com.pj.cherrypick.service;

<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> 90c2a17dc164839599fa280dd04f36e59f98bd82
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

@Service
public class MailService {
     
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail() {
        
        // 수신 대상을 담을 ArrayList 생성
        ArrayList<String> toUserList = new ArrayList<>();
        
        // 수신 대상 추가
        toUserList.add("수신대상1@gmail.com");
        toUserList.add("수신대상2@naver.com");
        
        // 수신 대상 개수
        int toUserSize = toUserList.size();
        
        // SimpleMailMessage (단순 텍스트 구성 메일 메시지 생성할 때 이용)
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        
        // 수신자 설정
        simpleMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));
        
        // 메일 제목
        simpleMessage.setSubject("Subject Sample");
        
        // 메일 내용
        simpleMessage.setText("Text Sample");
        
        // 메일 발송
        javaMailSender.send(simpleMessage);
    }
=======
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
>>>>>>> 90c2a17dc164839599fa280dd04f36e59f98bd82
}
