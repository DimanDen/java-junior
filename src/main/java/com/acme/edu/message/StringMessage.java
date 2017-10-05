package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

public class StringMessage extends Message {
    public StringMessage(StringBuilder content, Formatter formatter) {
        super(content, formatter);
    }
    private final String SEPARATOR = "\r\n";

    @Override
    public void formatContent(StringBuilder prevContent) {
        StringBuilder temp = new StringBuilder("");
        int tempNumbOfRepeatStr = 2;
        StringBuilder prevVal = new StringBuilder(prevContent);



        if(prevVal.toString().contains(getContent())) {
            prevVal.setLength(prevVal.toString().lastIndexOf(SEPARATOR));

            int beginOfCounter = prevVal.toString().lastIndexOf(" (x");
            if(beginOfCounter != -1) {
                prevVal.deleteCharAt(prevVal.lastIndexOf(")"));
                tempNumbOfRepeatStr = Integer.parseInt(prevVal.toString().substring(beginOfCounter + 3)) + 1;
                prevVal.setLength(beginOfCounter);
            }

            temp.append(prevVal.append(" (x").append(tempNumbOfRepeatStr).append(")"));
        } else {
            temp.append(prevContent.append(getContent()));
        }
        temp.append(SEPARATOR);
        setContent(temp);
    }

    @Override
    public boolean isSameType(Message prevMessage) {
        return prevMessage instanceof StringMessage;
    }

    @Override
    public void concatenateWithPrefix() {
        getFormatter().formatMessage(getContent());
    }
}
