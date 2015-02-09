package org.tobby.spring.guide.jms.receive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableAutoConfiguration
@EnableJms
public class ReceiveApplication {

	static String mailboxDestination = "mailbox-destination";
	
	@Bean
	Receiver receiver() {
		return new Receiver();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ReceiveApplication.class, args);
	}
}
