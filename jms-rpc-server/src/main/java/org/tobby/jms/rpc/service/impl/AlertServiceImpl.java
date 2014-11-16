package org.tobby.jms.rpc.service.impl;

import org.tobby.jms.rpc.domain.Alert;
import org.tobby.jms.rpc.service.AlertService;

public class AlertServiceImpl implements AlertService {

	public void sendAlert(Alert alert) {
		System.out.println("The sended message is " + alert.getId() + "with content " + alert.getContent());
	}

}
