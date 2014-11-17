package org.tobby.jms.lingo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tobby.jms.lingo.service.AlertService;

public class ClientEntry {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AlertService alertService = (AlertService)context.getBean("alertService");
		System.out.println("Preparing to send alert ... ");
		alertService.sendAlert("I am Tobby's Alert Hoooooo For Lingo Client");
		System.out.println("Alert sended done");
	}
}
