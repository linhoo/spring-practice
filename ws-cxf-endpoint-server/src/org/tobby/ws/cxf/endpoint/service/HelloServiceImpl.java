package org.tobby.ws.cxf.endpoint.service;

import javax.jws.WebService;

@WebService
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name + ", welcome to CXF world!";
	}

}
