package org.tobby.ws.cxf.webapp.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.tobby.ws.cxf.webapp.service.HelloService;

public class HelloServiceClient {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:8080/ws-cxf-webapp-server/services/helloService");
		factory.setServiceClass(HelloService.class);
		HelloService helloService = (HelloService)factory.create();
		System.out.println(helloService.sayHello("Tobby"));
	}
}
