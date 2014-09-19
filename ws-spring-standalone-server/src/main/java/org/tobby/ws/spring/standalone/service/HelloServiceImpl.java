package org.tobby.ws.spring.standalone.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "Welcome to Spring and JaxWs World, " + name;
	}

}
