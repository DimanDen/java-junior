package com.acme.edu.formatter;

import com.acme.edu.formatter.Formatter;

public class ByteFormatter implements Formatter {
    private final String BYTE_PREFIX = "primitive: ";

    @Override
    public StringBuilder formatMessage(StringBuilder message) {
        return message.insert(0, BYTE_PREFIX);
    }
}

