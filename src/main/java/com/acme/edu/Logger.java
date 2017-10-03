package com.acme.edu;

import com.acme.edu.formatter.*;
import com.acme.edu.message.*;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static void log(Object message) {
        loggerController.parseMessage(new ReferenceMessage(new StringBuilder(String.valueOf(message)),
                new ReferenceFormatter()));
    }

    public static void log(boolean message) {
        loggerController.parseMessage(new BooleanMessage(new StringBuilder(String.valueOf(message)),
                new BooleanFormatter()));
    }

    public static void log(char message) {
        loggerController.parseMessage(new CharMessage(new StringBuilder(String.valueOf(message)),
                new CharFormatter()));
    }

    public static void log(int[] message) {
        StringBuilder tempString = new StringBuilder("{");
        for(int i : message) {
            tempString.append(i + ", ");
        }
        tempString.setLength(tempString.length() - 2);
        tempString.append("}");

        loggerController.parseMessage(new ArrayOfIntMessage(new StringBuilder(tempString),
                new ArrayOfIntFormatter()));
    }

    public static void log(int message) {
        loggerController.parseMessage(new IntMessage(new StringBuilder(String.valueOf(message)),
                new IntFormatter()));
    }

    public static void log(String message) {
        loggerController.parseMessage(new StringMessage(new StringBuilder(String.valueOf(message)),
                new StringFormatter()));
    }

    public static void log(byte message) {
        loggerController.parseMessage(new ByteMessage(new StringBuilder(String.valueOf(message)),
                new ByteFormatter()));
    }

    public static void loggerStop() {
        loggerController.parseMessage(new StopMessage(new StringBuilder(""),
                new StringFormatter()));
    }

    public static void main(String[] args) {
    }
}