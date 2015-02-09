package org.tobby.spring.schedule.annotation;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleTask {

	@Scheduled(cron="0 0/2 * * * ?")
	public void work() {
		System.out.println("I am working" + new Date());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Async
	public void MyAsynchMethod() {
			for (int i=0; i <= 1000000; i ++) {
				System.out.print("");
			}
		System.out.println("My Asynch Method Is running ...");
	}
}
