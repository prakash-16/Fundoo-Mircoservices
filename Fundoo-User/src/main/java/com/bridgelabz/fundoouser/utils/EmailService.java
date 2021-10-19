package com.bridgelabz.fundoouser.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMail(String to, String from, String subject, String body) {
		try {
			SimpleMailMessage mailBox = new SimpleMailMessage();
			mailBox.setTo(to);
			mailBox.setFrom(from);
			mailBox.setSubject(subject);
			mailBox.setText(body);
			mailSender.send(mailBox);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
