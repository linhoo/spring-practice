package org.tobby.jms.spring.receive;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;

public class JmsTemplateReceiver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		JmsTemplate jmsTemplate = (JmsTemplate)context.getBean("jmsTemplate");
		System.out.println("JmsTemplate start reveiving...");
		TextMessage message = (TextMessage)jmsTemplate.receive();
		try {
			String text = message.getText();
			System.out.println(new Date() + text);
		} catch (JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}
	}
}
