package org.tobby.spring.spitter.rmi.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerEntry {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("application-context.xml");
	}
}
