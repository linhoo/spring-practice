package org.tobby.ws.spring.standalone.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tobby.ws.spring.standalone.service.HelloService;

@Component
@WebService(name="helloService", serviceName="myHelloService")
public class HelloServiceEndpoint {

	@Autowired
	private HelloService helloService;
	
	@WebMethod
	public String sayHello(String name) {
		return helloService.sayHello(name);
	}
	
}
