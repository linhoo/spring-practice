package org.tobby.jms.rpc.service;

import org.tobby.jms.rpc.domain.Alert;

public interface AlertService {
	void sendAlert(String alert);
}
