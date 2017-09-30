package com.acme.edu;

public class Logger {
    private static final String PREFIX_ARRAY = "primitives array: ";
    private static final String DELIMITER = "\r\n";
    private static StringBuilder buffer = new StringBuilder("");
    private static String currentType = "";

    private static Integer counterStringRepeat = 1;
    private static Integer sequentIntSum = 0;
    private static Byte sequentByteSum = 0;

    private static void printAndResetBuffer() {
        print(buffer);
        clearBuffer();
        sequentIntSum = 0;
        sequentByteSum = 0;
        counterStringRepeat = 1;
    }

    public static void loggerStop() {
        print(buffer);
        clearBuffer();
    }

    private static void checkCurrentType(String className) {
        if(!className.equals(currentType) || currentType.equals("")) {

            if(!currentType.equals("")) {
                printAndResetBuffer();
            }

            clearBuffer();
            sequentIntSum = 0;
            sequentByteSum = 0;
            counterStringRepeat = 1;

            currentType = className;
        }
    }

    private static void clearBuffer() {
        buffer.setLength(0);
    }


    private static void print(StringBuilder message) {
        System.out.print(message);
    }

    public static long parseDigits(long message, long maxValue, long sequentSum) {
        clearBuffer();
        if(maxValue - (sequentSum + message) < 0) {
            if(sequentSum > message ) {
                buffer.append(maxValue);
                printAndResetBuffer();
                sequentSum = - (maxValue - (sequentSum + message));
            } else {
                buffer.append(sequentSum + DELIMITER);
                printAndResetBuffer();
                sequentSum = message;
            }
        }
        else {
            sequentSum += message;
            clearBuffer();

        }
        return sequentSum;
    }

    public static void log(String message) {
        checkCurrentType("String");


        if(buffer.toString().contains(message)) {
            ++counterStringRepeat;
            int tempLength = buffer.length();
            buffer.delete(tempLength - 2, tempLength + 1);

            if(counterStringRepeat > 2) {
                int indexOfEndMessage = buffer.toString().lastIndexOf(message) + message.length();
                buffer = new StringBuilder(buffer.substring(0, indexOfEndMessage));
                buffer.append(" (x" + counterStringRepeat + ")" + DELIMITER);
            } else {
                buffer.append(" (x" + counterStringRepeat + ")" + DELIMITER);
            }

        } else {
            buffer.append(message + DELIMITER);
        }
    }

    public static void log(String message, String prefix) {
        print(new StringBuilder(prefix + message + "\r\n"));
    }

    public static void log(int message) {
        checkCurrentType("Integer");
        sequentIntSum = (int)parseDigits(message, Integer.MAX_VALUE, sequentIntSum);
        buffer.append(sequentIntSum + DELIMITER);
    }

    public static void log(int message, String prefix) {
        print(new StringBuilder(prefix + message + "\r\n"));
    }

    public static void log(byte message) {
        checkCurrentType("Byte");
        sequentByteSum = (byte)parseDigits(message, Byte.MAX_VALUE, sequentByteSum);
        buffer.append(sequentByteSum + DELIMITER);
    }

    public static void log(byte message, String prefix) {
        print(new StringBuilder(prefix + message + "\r\n"));
    }

    public static void log(char message, String prefix) {
        print(new StringBuilder(prefix + message + "\r\n"));
    }

    public static void log(int[] message) {
        buffer.append(PREFIX_ARRAY);
        buffer.append("{");
        for(int element: message) {
            buffer.append(element + ", ");
        }
        buffer.delete(buffer.length() - 2, buffer.length() + 1);
        buffer.append("}" + DELIMITER);
        print(buffer);
    }

    public static void log(boolean message, String prefix) {
        print(new StringBuilder(prefix + message + "\r\n"));
    }

    public static void log(Object message, String prefix) {
        print(new StringBuilder(prefix + message + "\r\n"));
    }

    public static void main(String[] args) {
    }
}