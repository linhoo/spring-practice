package org.tobby.jms.lingo.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerEntry {

	public static void main(String[] args) {
		System.out.println("Server started to listening ... ");
		new ClassPathXmlApplicationContext("application-context.xml");
	}
}
