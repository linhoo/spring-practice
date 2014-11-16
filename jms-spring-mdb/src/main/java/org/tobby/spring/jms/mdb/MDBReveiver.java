package org.tobby.spring.jms.mdb;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MDBReveiver {
    public static void main( String[] args ) {
        new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println("Message Driven Bean start receiving...");
    }

    public void processMessage(String text) {
    	System.out.println(new Date() + "Reveivied message is " + text);
    }
}
