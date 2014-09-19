package org.tobby.ws.spring.client;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tobby.ws.spring.endpoint.HelloService;

public class HelloServiceClient {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;
		HelloService helloService = null;
		
		try {
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			helloService = (HelloService)context.getBean("helloService");
		} finally {
			if (context != null) {
				context.close();
			}
		}
		System.out.println(helloService.sayHello("Tobby"));
	}
}
