package org.tobby.spring.remoting.burlap.client;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientEntry {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;
		HelloService helloService = null;
		try {
			context = new ClassPathXmlApplicationContext("application-context.xml");
			helloService = (HelloService)context.getBean("helloService");
		} finally {
			if (context != null) {
				context.close();
			}
		}
		System.out.println(helloService.sayHello("Tobby"));
	}

}
