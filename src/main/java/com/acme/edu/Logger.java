package com.acme.edu;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static void log(int message, String prefix) {
        Message messageWithPrefix = new Message();

        messageWithPrefix.setContent(new StringBuilder(prefix + String.valueOf(message)));
        messageWithPrefix.setContentType(new StringBuilder("String"));

        loggerController.parseMessage(messageWithPrefix);
    }

    public static void log(byte message, String prefix) {
        Message messageWithPrefix = new Message();

        messageWithPrefix.setContent(new StringBuilder(prefix + String.valueOf(message)));
        messageWithPrefix.setContentType(new StringBuilder("String"));

        loggerController.parseMessage(messageWithPrefix);
    }

    public static void log(char message, String prefix) {
        Message messageWithPrefix = new Message();

        messageWithPrefix.setContent(new StringBuilder(prefix + String.valueOf(message)));
        messageWithPrefix.setContentType(new StringBuilder("String"));

        loggerController.parseMessage(messageWithPrefix);
    }

    public static void log(String message, String prefix) {
        Message messageWithPrefix = new Message();

        messageWithPrefix.setContent(new StringBuilder(prefix + String.valueOf(message)));
        messageWithPrefix.setContentType(new StringBuilder("String"));

        loggerController.parseMessage(messageWithPrefix);
    }

    public static void log(Boolean message, String prefix) {
        Message messageWithPrefix = new Message();

        messageWithPrefix.setContent(new StringBuilder(prefix + String.valueOf(message)));
        messageWithPrefix.setContentType(new StringBuilder("String"));

        loggerController.parseMessage(messageWithPrefix);
    }

    public static void log(Object message, String prefix) {
        Message messageWithPrefix = new Message();

        messageWithPrefix.setContent(new StringBuilder(prefix + String.valueOf(message)));
        messageWithPrefix.setContentType(new StringBuilder("String"));

        loggerController.parseMessage(messageWithPrefix);
    }

    public static void log(int[] message, String prefix) {
        Message messageWithPrefix = new Message();

        StringBuilder tempString = new StringBuilder("{");
        for(int i : message) {
            tempString.append(i + ", ");
        }
        tempString.setLength(tempString.length() - 2);
        tempString.append("}");

        messageWithPrefix.setContent(new StringBuilder(prefix + tempString));
        messageWithPrefix.setContentType(new StringBuilder("String"));

        loggerController.parseMessage(messageWithPrefix);
    }

    public static void log(int message) {
        Message intMessage = new Message();

        intMessage.setContent(new StringBuilder(String.valueOf(message)));
        intMessage.setContentType(new StringBuilder("Integer"));

        loggerController.parseMessage(intMessage);
    }

    public static void log(String message) {
        Message stringMessage = new Message();

        stringMessage.setContent(new StringBuilder(String.valueOf(message)));
        stringMessage.setContentType(new StringBuilder("String"));

        loggerController.parseMessage(stringMessage);
    }

    public static void log(byte message) {
        Message stringMessage = new Message();

        stringMessage.setContent(new StringBuilder(String.valueOf(message)));
        stringMessage.setContentType(new StringBuilder("Byte"));

        loggerController.parseMessage(stringMessage);
    }

    public static void loggerStop() {
        Message stopSignalMessage = new Message();

        stopSignalMessage.setContent(new StringBuilder(""));
        stopSignalMessage.setContentType(new StringBuilder("StopSignal"));

        loggerController.parseMessage(stopSignalMessage);
    }

    public static void main(String[] args) {
    }
}