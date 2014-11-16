package org.tobby.jms.rpc.service.impl;

import org.tobby.jms.rpc.service.AlertService;

public class AlertServiceImpl implements AlertService {

	public void sendAlert(String alert) {
		System.out.println("The sended message is " + alert);
	}

}
