package org.tobby.jms.rpc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tobby.jms.rpc.domain.Alert;
import org.tobby.jms.rpc.service.AlertService;

public class ClientEntry {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AlertService alertService = (AlertService)context.getBean("alertService");
		Alert alert = new Alert();
		alert.setId(879);
		alert.setContent("I am Tobby's Alert");
		System.out.println("Preparing to send alert ... ");
		alertService.sendAlert(alert);
		System.out.println("Alert sended done");
	}
}
