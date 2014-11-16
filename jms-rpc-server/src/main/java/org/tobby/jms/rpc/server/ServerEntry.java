package org.tobby.jms.rpc.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerEntry {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("application-context.xml");
		System.out.println("RPC server started to listen ... ");
	}
}
