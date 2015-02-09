package org.tobby.spring.jmx.listener;

import javax.management.Notification;
import javax.management.NotificationListener;

public class PagingNotificationListener implements NotificationListener {

	public void handleNotification(Notification notification, Object handback) {
		System.out.println("I am Handing the notification");
		System.out.println("------YOU ARE RIGHT------");
	}

}
