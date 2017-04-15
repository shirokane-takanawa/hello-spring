package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author shirokane-takanawa
 */
public class FileEventLogger implements EventLogger {

    private String filename;
    private File file;

    private FileEventLogger(String filename) {
        this.filename = filename;
    }

    private void init() throws IOException {
        this.file = new File(filename);
        if(!file.canWrite()){
            throw new IOException("file is busy");
        }
    }

    public void logEvent(Event event) {

        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
