package com.acme.edu;

public class Logger {

    public static String getTextBeforeLog(Object message) {
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


    public static void log(String message) {
        System.out.println(getTextBeforeLog(message) + message);
    }

    public static void log(char message) {
        System.out.println(getTextBeforeLog(message) + message);
    }

    public static void log(int message) {
        System.out.println(getTextBeforeLog(message) + message);
    }

    public static void log(byte message) {
        System.out.println(getTextBeforeLog(message) + message);
    }

    public static void main(String[] args) {
        System.out.println("HERE'S JOHNY");
    }
}
////////