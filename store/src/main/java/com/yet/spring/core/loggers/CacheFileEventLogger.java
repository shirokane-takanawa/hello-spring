package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shirokane-takanawa
 */
public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;

    }

    @Override
    public void logEvent(Event event){
        cache.add(event);
        if(cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache(){
        for(Event event:cache){
            super.logEvent(event);
        }
    }

    private void destroy(){
        if(!cache.isEmpty())
            writeEventsFromCache();
    }

}
