package com.acme.edu;

public class StringFormatter implements Formatter {
    private final String STRING_DELIMITER = "\r\n";

    @Override
    public StringBuilder format(StringBuilder prevContentBuffer, StringBuilder currentContentMessage) {
        StringBuilder temp = new StringBuilder("");
        int tempNumbOfRepeatStr = 2;
        if(prevContentBuffer.toString().contains(currentContentMessage)) {
            prevContentBuffer.setLength(prevContentBuffer.toString().lastIndexOf(STRING_DELIMITER));

            int beginOfCounter = prevContentBuffer.toString().lastIndexOf(" (x");
            if(beginOfCounter != -1) {
                prevContentBuffer.deleteCharAt(prevContentBuffer.lastIndexOf(")"));
                tempNumbOfRepeatStr = Integer.parseInt(prevContentBuffer.toString().substring(beginOfCounter + 3)) + 1;
                prevContentBuffer.setLength(beginOfCounter);
            }

            temp.append(prevContentBuffer.append(" (x").append(tempNumbOfRepeatStr).append(")"));
        } else {
            temp.append(prevContentBuffer.append(currentContentMessage));
        }

        return temp;
    }
}
