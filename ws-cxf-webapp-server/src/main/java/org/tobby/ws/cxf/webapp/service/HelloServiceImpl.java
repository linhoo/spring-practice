package org.tobby.ws.cxf.webapp.service;

import javax.jws.WebService;

@WebService
public class HelloServiceImpl implements HelloService {

	public String sayHello(String name) {
		return "Hello " + name + ", welcome to CXF world!";
	}

}
