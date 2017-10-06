package com.acme.edu.message;
import com.acme.edu.Exceptions.SaverException;
import com.acme.edu.formatter.*;

public abstract class Message {
    private StringBuilder content;
    private Formatter formatter;

    Message(StringBuilder content, Formatter formatter) {
        this.content = content;
        this.formatter= formatter;
    }

    public StringBuilder getContent() {
        return content;
    }

    void setContent(StringBuilder content) {
        this.content = content;
    }

    protected Formatter getFormatter() {
        return formatter;
    }

    public abstract void formatContent(StringBuilder prevContent) throws SaverException;
    public abstract boolean isSameType(Message prevMessage);
    public abstract void concatenateWithPrefix();
}
