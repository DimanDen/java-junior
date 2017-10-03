package com.acme.edu.formatter;

public class BooleanFormatter implements Formatter {
    private final String BOOLEAN_PREFIX = "primitive: ";

    @Override
    public StringBuilder formatMessage(StringBuilder message) {
        return message.insert(0, BOOLEAN_PREFIX);
    }
}
