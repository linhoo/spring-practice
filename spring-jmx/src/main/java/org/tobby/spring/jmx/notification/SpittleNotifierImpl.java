package org.tobby.spring.jmx.notification;

import javax.management.Notification;

import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.tobby.spring.jmx.controller.HomeController;

@ManagedResource("Spitter:name=SpitterNotifier")
@ManagedNotification(notificationTypes="SpittleNotifier.OneMillionSpittles", name="TODO")
public class SpittleNotifierImpl implements NotificationPublisherAware, SpittleNotifier {

	private NotificationPublisher notificationPublisher;

	@ManagedOperation
	public void millionthSpittlePosted() {
		notificationPublisher.sendNotification(
				new Notification("SpittleNotifier.OneMillionSpittles", this, 0));
	}

	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
		this.notificationPublisher = notificationPublisher;

	}

}
