package org.tobby.ws.spring.standalone.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
}
