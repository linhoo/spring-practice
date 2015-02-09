package org.tobby.spring.jmx.client;

import java.io.IOException;

import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tobby.spring.jmx.access.HomeControllerManagedOperations;

/**
 * Hello world!
 *
 */
public class JmxClient {
	
	private MBeanServerConnection mBeanServerConnection;

	public MBeanServerConnection getmBeanServerConnection() {
		return mBeanServerConnection;
	}

	public void setmBeanServerConnection(MBeanServerConnection mBeanServerConnection) {
		this.mBeanServerConnection = mBeanServerConnection;
	}

	public static void main( String[] args ) throws IOException, AttributeNotFoundException, InstanceNotFoundException, MalformedObjectNameException, MBeanException, ReflectionException, InvalidAttributeValueException {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JmxClient jmxClient = (JmxClient)context.getBean("jmxClient");
        System.out.println("正在运行的托管Bean" + jmxClient.getmBeanServerConnection().getMBeanCount());
        for (ObjectInstance oName : jmxClient.getmBeanServerConnection().queryMBeans(null, null)) {
        	System.out.println(oName);
        }
        Integer cronExpression = (Integer) jmxClient.getmBeanServerConnection().getAttribute(
        		new ObjectName("spitter:name=HomeController"), "SpittlesPerPage");
        System.out.println("获取到的spittlesPerPage属性值是：" + cronExpression);
        jmxClient.getmBeanServerConnection().setAttribute(
        		new ObjectName("spitter:name=HomeController"), new Attribute("SpittlesPerPage", 998));
        jmxClient.getmBeanServerConnection().invoke(
        		new ObjectName("spitter:name=HomeController"), "setSpittlesPerPage",
        		new Object[]{10}, new String[]{"int"});
        HomeControllerManagedOperations homeController = (HomeControllerManagedOperations)context.getBean("remoteHomeControllerMBean");
        homeController.setSpittlesPerPage(445667);
	}
}
