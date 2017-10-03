package com.acme.edu.formatter;

public class CharFormatter implements Formatter {
    private final String CHAR_PREFIX = "char: ";

    @Override
    public StringBuilder formatMessage(StringBuilder message) {
        return message.insert(0, CHAR_PREFIX);
    }
}
