package com.acme.edu.message;
import com.acme.edu.Saver;
import com.acme.edu.formatter.Formatter;

public class IntMessage extends Message {
    private Saver saver = new Saver();
    public IntMessage(StringBuilder content, Formatter formatter) {
        super(content, formatter);
    }

    @Override
    public void formatContent(StringBuilder prevContent) {
        StringBuilder temp = new StringBuilder("");
        int prevVal;
        int currentVal;

        if(prevContent.length() == 0) {
            prevVal = 0;
        } else {
            prevVal = Integer.parseInt(prevContent.toString());
        }

        currentVal = Integer.parseInt(getContent().toString());

        if(Integer.MAX_VALUE - (prevVal + currentVal) < 0) {
            if(prevVal > currentVal ) {
                temp.append(Integer.MAX_VALUE);
                prevVal = - (Integer.MAX_VALUE - (prevVal + currentVal));
            } else {
                temp.append(prevVal);
                prevVal = currentVal;
            }

            setContent(temp);
            concatenateWithPrefix();
            saver.save(getContent());

            temp.setLength(0);
            temp.append(prevVal);
        } else {
            temp.append((prevVal + currentVal));
        }

        setContent(temp);
    }

    @Override
    public boolean isSameType(Message prevMessage) {
        return prevMessage instanceof IntMessage;
    }

    @Override
    public void concatenateWithPrefix() {
        getFormatter().formatMessage(getContent());
    }
}
