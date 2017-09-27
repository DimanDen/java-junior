package com.acme.edu;

public class Logger {
    static String textBeforeLog = "primitive ";

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(int message) {
        System.out.println(textBeforeLog + message);
    }

    public static void log(byte message) {
        System.out.println(textBeforeLog + message);
    }

    public static void main(String[] args) {
        System.out.println("HERE'S JOHNY");
    }
}
////////