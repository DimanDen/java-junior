package com.acme.edu.formatter;

public class ArrayOfIntFormatter implements Formatter {
    private final String ARRAY_OF_INT_PREFIX = "primitives array: ";

    @Override
    public StringBuilder formatMessage(StringBuilder message) {
        return message.insert(0, ARRAY_OF_INT_PREFIX);
    }
}
