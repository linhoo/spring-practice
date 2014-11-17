package org.tobby.jms.lingo.service.impl;

import org.tobby.jms.lingo.service.AlertService;

public class AlertServiceImpl implements AlertService {

	public void sendAlert(String alert) {
		System.out.println("The sended message is 4444444" + alert);
	}

}
