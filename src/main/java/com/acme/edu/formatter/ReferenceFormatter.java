package com.acme.edu.formatter;

public class ReferenceFormatter implements Formatter {
    private final String REFERENCE_PREFIX = "reference: ";

    @Override
    public StringBuilder formatMessage(StringBuilder message) {
        return message.insert(0, REFERENCE_PREFIX);
    }
}
