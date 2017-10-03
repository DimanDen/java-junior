package com.acme.edu.message;

import com.acme.edu.formatter.Formatter;

public class StringMessage extends Message {
    public StringMessage(StringBuilder content, Formatter formatter) {
        super(content, formatter);
    }

    @Override
    public void formatContent(StringBuilder prevContent) {
        StringBuilder temp = new StringBuilder("");
        int tempNumbOfRepeatStr = 2;
        StringBuilder prevVal = new StringBuilder(prevContent);



        if(prevVal.toString().contains(getContent())) {
            prevVal.setLength(prevVal.toString().lastIndexOf("\r\n"));

            int beginOfCounter = prevVal.toString().lastIndexOf(" (x");
            if(beginOfCounter != -1) {
                prevVal.deleteCharAt(prevVal.lastIndexOf(")"));
                tempNumbOfRepeatStr = Integer.parseInt(prevVal.toString().substring(beginOfCounter + 3)) + 1;
                prevVal.setLength(beginOfCounter);
            }

//            if(prevContent.toString() != "") {
//                temp.append("\r\n");
//            }
            temp.append(prevVal.append(" (x").append(tempNumbOfRepeatStr).append(")"));
//            temp.append("\r\n");
        } else {

//            if(prevContent.toString() != "") {
//                temp.append("\r\n");
//            }
            temp.append(prevContent.append(getContent()));

        }
        temp.append("\r\n");
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
