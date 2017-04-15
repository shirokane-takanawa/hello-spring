package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

/**
 * @author shirokane-takanawa
 */
public interface EventLogger {

    void logEvent(Event event);
}
