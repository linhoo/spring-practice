package org.tobby.ws.cxf.endpoint.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.tobby.ws.cxf.endpoint.service.HelloService;

public class HelloServiceClient {
	
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloService.class);
		factory.setAddress("http://localhost:8899/helloService");
		HelloService helloService = (HelloService)factory.create();
		System.out.println(helloService.sayHello("My Tobby"));
	}
}
