package org.tobby.ws.java.service;

import java.text.DateFormat;
import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface="org.tobby.ws.java.service.TimeService")
public class TimeServiceImpl implements TimeService {

	@Override
	public String getTimeAsString() {
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance();
		return df.format(date);
	}

	@Override
	public long getTimeAsElapsed() {
		return new Date().getTime();
	}

}
