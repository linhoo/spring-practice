package org.tobby.spring.mail;

import javax.mail.MessagingException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tobby.spring.mail.domain.Spittle;

public class MailSender {

	public static void main(String[] args) throws MessagingException {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		SpitterEmailServiceImpl spitterMailService = (SpitterEmailServiceImpl)context.getBean("spitterMailService");
		//spitterMailService.sendSimpleSpittleEmail("lilinhu22@camelotchina.com", new Spittle("ni hao a"));
		//spitterMailService.sendMimeSpittleEmail("lilinhu22@camelotchina.com", new Spittle("ni hao a"));
		//spitterMailService.sendHtmlSpittleEmail("lilinhu22@camelotchina.com", new Spittle("ni hao a"));
		spitterMailService.sendTemplateSpittleEmail("lilinhu22@camelotchina.com", new Spittle("ni hao a"));
	}
}
