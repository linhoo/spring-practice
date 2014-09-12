package org.tobby.spring.spitter.rmi.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientEntry {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = null;
		HelloService helloService;
		try {
			context = new ClassPathXmlApplicationContext("application-context.xml");
			helloService = (HelloService)context.getBean("helloService");
		} finally {
			context.close();
		}
		System.out.println(helloService.sayHello("My Name is Tobby"));
	}
}
