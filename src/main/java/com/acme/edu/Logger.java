package com.acme.edu;

public class Logger {

    private static String getTextBeforeLog(Object message) {
        String textBeforeLog = "";

        if(message != null) {
            if(String.class.equals(message.getClass())) {
                textBeforeLog = "string: ";
            }
            else if(Character.class.equals(message.getClass())) {
                textBeforeLog = "char: ";
            }
            else if(Integer.class.equals(message.getClass()) ||
                    Byte.class.equals(message.getClass())) {
                textBeforeLog = "primitive: ";
            }
        }


        return textBeforeLog;
    }

    private static void print(String message) {
        System.out.println(message);
    }


    public static void log(String message) {
        print(getTextBeforeLog(message) + message);
    }

    public static void log(char message) {
        print(getTextBeforeLog(message) + message);
    }

    public static void log(int message) {
        print(getTextBeforeLog(message) + message);
    }

    public static void log(byte message) {
        print(getTextBeforeLog(message) + message);
    }

    public static void main(String[] args) {
    }
}
////////