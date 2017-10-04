package com.acme.edu.message;

import com.acme.edu.Saver;
import com.acme.edu.formatter.Formatter;

import java.lang.reflect.Array;

public class ArrayOfIntMessage extends Message {
    public ArrayOfIntMessage(StringBuilder content, Formatter formatter) {
        super(content, formatter);
    }

    @Override
    public void formatContent(StringBuilder prevContent) {
        StringBuilder temp = new StringBuilder("");
        temp.append(prevContent.append(getContent()));
        setContent(temp);
    }

    @Override
    public boolean isSameType(Message prevMessage) {
        return prevMessage instanceof ReferenceMessage;
    }

    @Override
    public void concatenateWithPrefix() {
        getFormatter().formatMessage(getContent());
    }
}
