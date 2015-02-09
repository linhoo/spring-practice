package org.tobby.spring.guide.jms.receive;

import org.springframework.jms.annotation.JmsListener;

public class Receiver {
	
	@JmsListener(destination="mailbox-destination")
	public void receiveMessage(String message) {
		System.out.println("Received < " + message + " >");
	}

}
