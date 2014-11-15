package org.tobby.jms.spring.send;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsTemplateSender {

	public static void main(String[] args) {
		JmsTemplateSender sender = new JmsTemplateSender();
		sender.sendMessage("This is the Spring Tobby Message");
	}
	
	public void sendMessage(final String text) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		JmsTemplate jmsTemplate = (JmsTemplate)context.getBean("jmsTemplate");
		jmsTemplate.send("spitter.queue", new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(text);
			}
		});
	}
}
