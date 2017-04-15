package com.yet.spring.core.beans;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;

/**
 * @author shirokane-takanawa
 */
public class Event {

    private static int counter = 0;

    private int id = counter++;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df){
        this.date = date;
        this.df = df;
    }

    public String toString(){
        return MessageFormat
                .format("id:{0}, msg:{1}, date:{2}\n", id, msg, df.format(date));
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
