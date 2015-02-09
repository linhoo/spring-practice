package org.tobby.spring.schedule;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScheduleStart {

	   public static void main( String[] args )
	    {
	      ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	      
	    }
}
