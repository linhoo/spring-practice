package org.tobby.spring.jmx.controller;

import java.io.Serializable;

import javax.management.Notification;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

@ManagedResource(objectName="spitter:name=HomeController")
public class HomeController implements NotificationPublisherAware, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	
	private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;
	
	private NotificationPublisher notificationPublisher;

	public void showHomePage() {
		System.out.println("ILOVEYTOU");
	}
	
	@ManagedAttribute
	//@ManagedOperation
	public int getSpittlesPerPage() {
		return spittlesPerPage;
	}

	@ManagedAttribute
	//@ManagedOperation
	public void setSpittlesPerPage(int spittlesPerPage) {
		this.spittlesPerPage = spittlesPerPage;
		notificationPublisher.sendNotification(new Notification("ILOVEYOU", this, 23));
	}

	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
		this.notificationPublisher = notificationPublisher;
	}

}
