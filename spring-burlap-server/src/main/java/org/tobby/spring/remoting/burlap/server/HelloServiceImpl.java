package org.tobby.spring.remoting.burlap.server;

public class HelloServiceImpl implements HelloService {

	public String sayHello(String name) {
		System.out.println(name);
		return "My name is " + name;
	}

}
