package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

/**
 * @author shirokane-takanawa
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event msg) {
        System.out.println("Logging event:" + msg);
    }
}
