package com.acme.edu.formatter;

public class IntFormatter implements Formatter {
    private final String INTEGER_PREFIX = "primitive: ";

    @Override
    public StringBuilder formatMessage(StringBuilder message) {
        return message.insert(0, INTEGER_PREFIX);
    }
}

