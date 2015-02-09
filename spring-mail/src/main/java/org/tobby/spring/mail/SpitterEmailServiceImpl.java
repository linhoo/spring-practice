package org.tobby.spring.mail;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.tobby.spring.mail.domain.Spittle;

public class SpitterEmailServiceImpl {

	private JavaMailSender javaMailSender;

	private VelocityEngine velocityEngine;

	public void sendSimpleSpittleEmail(String to, Spittle spittle) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("289047134@qq.com");
		mailMessage.setTo(to);
		mailMessage.setSubject("New Spittle from Spitter");
		mailMessage.setText(spittle.getText());
		javaMailSender.send(mailMessage);
	}
	
	public void sendMimeSpittleEmail(String to, Spittle spittle) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("289047134@qq.com");
		helper.setTo(to);
		helper.setSubject("New MIME EMAIL from Tobby");
		helper.setText(spittle.getText());
		FileSystemResource grandMaImage = new FileSystemResource("/IMG_0007.JPG");
		helper.addAttachment("GrandMa.JPG", grandMaImage);
		javaMailSender.send(message);
	}
	
	public void sendHtmlSpittleEmail(String to, Spittle spittle) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("289047134@qq.com");
		helper.setTo(to);
		helper.setSubject("New MIME EMAIL from Tobby");
		helper.setText("<html><body><img src='cid:spitterLogo'>"+
				"<h4>"+"tobby "+" says...</h4>"+
				"<i>"+spittle.getText()+"</i>"+
				"</body></html>", true);
		ClassPathResource image = new ClassPathResource("IMG_0007.JPG");
		helper.addInline("spitterLogo", image);
		javaMailSender.send(message);
	}
	
	public void sendTemplateSpittleEmail(String to, Spittle spittle) throws MessagingException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("spitterName", "tobby");
		model.put("spittleText", "I love you");
		String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
				"emailTemplate.vm", "UTF-8", model);
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("289047134@qq.com");
		helper.setTo(to);
		helper.setSubject("New MIME EMAIL from Tobby");
		helper.setText(emailText, true);
		ClassPathResource image = new ClassPathResource("IMG_0007.JPG");
		helper.addInline("spitterLogo", image);
		javaMailSender.send(message);
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

}
