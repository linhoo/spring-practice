package org.tobby.spring.jmx.entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartEntry {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object lock = new Object();
		synchronized (lock) {
			lock.wait();
		}
	}
}
