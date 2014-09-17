package org.tobby.ws.java.service;

import javax.jws.WebService;

@WebService
public interface TimeService {
	
	String getTimeAsString();
	
	long getTimeAsElapsed();
}
