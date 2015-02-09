package org.tobby.spring.schedule.annotation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class ScheduleStart 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ScheduleTask task = new ScheduleTask();
        task.MyAsynchMethod();
        System.out.println("Executed after asynch");
    }
}
