package com.acme.edu;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static void log(int message) {
        Message intMessage = new Message();
        intMessage.setContent(new StringBuilder(String.valueOf(message)));
        intMessage.setContentType(new StringBuilder("Integer"));

        loggerController.setCurrentMessage(intMessage);
    }

    public static void log(byte message) {

    }

    public static void log(String message) {

    }

    public static void log(int[] message) {

    }

    public static void loggerStop() {

    }

    public static void main(String[] args) {
        Logger.log(1);
        Logger.log(2);
    }
}