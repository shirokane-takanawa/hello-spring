package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shirokane-takanawa
 */
public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event e) {
        String message = e.getMsg().replaceAll(
                client.getId(), client.getFullName()
        );
        e.setMsg(message);
        eventLogger.logEvent(e);
    }

    public static void main(String args[]) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        Event event1 = (Event) ctx.getBean("event");
        event1.setMsg("message for client 1");
        app.logEvent(event1);

        Event event2 = (Event) ctx.getBean("event");
        event2.setMsg("message for client 2");
        app.logEvent(event2);

        ctx.close();
    }
}
