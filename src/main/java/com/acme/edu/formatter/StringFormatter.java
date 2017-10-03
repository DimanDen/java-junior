package com.acme.edu.formatter;

public class StringFormatter implements Formatter {
    private final String STRING_PREFIX = "string: ";

    @Override
    public StringBuilder formatMessage(StringBuilder message) {
        return message.insert(0, STRING_PREFIX);
    }
}
