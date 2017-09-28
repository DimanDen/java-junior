package com.acme.edu;

public class Logger {
    private static final String PREFIX_ARRAY = "primitives array: ";
    private static StringBuilder buffer = new StringBuilder("");
    private static String currentType = "";

    private static StringBuilder sequentStringSum = new StringBuilder("");
    private static Integer counterStringRepeat = 1;
    private static Integer sequentIntSum = 0;
    private static Byte sequentByteSum = 0;

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
            sequentIntSum = 0;
            sequentByteSum = 0;
            counterStringRepeat = 1;
            sequentStringSum.setLength(0);

            currentType = className;
        }
    }

    private static void clearBuffer() {
        buffer.setLength(0);
    }


    private static void print(StringBuilder message) {
        System.out.print(message);
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
                buffer.append(" (x" + counterStringRepeat + ")" + "\r\n");
            }
            else {
                buffer.append(" (x" + counterStringRepeat + ")" + "\r\n");
            }



        } else {
            buffer.append(message + "\r\n");
        }
    }

    public static void log(int message) {
        checkCurrentType("Integer");

        clearBuffer();
        if(Integer.MAX_VALUE - (sequentIntSum + message) < 0) {
            if(sequentIntSum > message ) {
                buffer.append(Integer.MAX_VALUE);
                printAndResetBuffer();
                sequentIntSum = - (Integer.MAX_VALUE - (sequentIntSum + message));
            } else {
                buffer.append(sequentIntSum + "\r\n");
                printAndResetBuffer();
                sequentIntSum = message;
            }
        }
        else {
            sequentIntSum += message;
            clearBuffer();

        }
        buffer.append(sequentIntSum + "\r\n");
    }

    public static void log(byte message) {
        checkCurrentType("Byte");

        clearBuffer();
        if(Byte.MAX_VALUE - (sequentByteSum + message) < 0) {
            if(sequentByteSum > message ) {
                buffer.append(Byte.MAX_VALUE);
                printAndResetBuffer();
                sequentByteSum = (byte) - (Byte.MAX_VALUE - (sequentIntSum + message));
            } else {
                buffer.append(sequentByteSum + "\r\n");
                printAndResetBuffer();
                sequentByteSum = message;
            }
        }
        else {
            sequentByteSum = (byte)(sequentByteSum + message);
            clearBuffer();

        }
        buffer.append(sequentByteSum + "\r\n");
    }

    public static void log(int[] message) {
        buffer.append(PREFIX_ARRAY);
        buffer.append("{");
        for(int element: message) {
            buffer.append(element + ", ");
        }
        buffer.delete(buffer.length() - 2, buffer.length() + 1);
        buffer.append("}" + "\r\n");
        print(buffer);
    }

    public static void main(String[] args) {

    }
}