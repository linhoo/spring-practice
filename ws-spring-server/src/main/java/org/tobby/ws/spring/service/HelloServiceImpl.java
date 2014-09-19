package org.tobby.ws.spring.service;

public class HelloServiceImpl implements HelloService {

	public String sayHello(String name) {
		return "Hello " + name + ", Welcome to JaxWs world!";
	}

}
