package com.acme.edu;

public class Logger {
    private static StringBuilder buffer = new StringBuilder("");
    private static String currentType = "";
    private static Integer sequentSum = 0;


    private static void printAndResetBuffer() {
        print(buffer);
        clearBuffer();
    }

    public static void loggerStop() {
        print(buffer);
    }

    private static void checkCurrentType(String className) {
        if(!className.equals(currentType) || currentType.equals("")) {

            if(!currentType.equals("")) {
                printAndResetBuffer();
            }

            clearBuffer();
            sequentSum = 0;
            currentType = className;
        }
    }

    private static void clearBuffer() {
        buffer.setLength(0);
    }


    private static void print(StringBuilder message) {
        System.out.println(message);
    }


    public static void log(String message) {
        checkCurrentType(String.class.toString());

        buffer.append(message);
    }


    public static void log(int message) {
        checkCurrentType(Integer.class.toString());

        sequentSum += message;
        clearBuffer();
        buffer.append(sequentSum);
    }

    public static void main(String[] args) {

    }
}