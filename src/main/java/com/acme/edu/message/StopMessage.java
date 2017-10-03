package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

public class StopMessage extends Message{
    public StopMessage(StringBuilder content, Formatter formatter) {
        super(content, formatter);
    }

    @Override
    public void formatContent(StringBuilder prevContent) {

    }

    @Override
    public boolean isSameType(Message prevMessage) {
        return prevMessage instanceof StopMessage;
    }

    @Override
    public void concatenateWithPrefix() {
    }
}
