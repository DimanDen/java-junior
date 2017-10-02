package com.acme.edu;

public class IntFormatter implements Formatter {

    @Override
    public StringBuilder format(StringBuilder prevContentBuffer, StringBuilder currentContentMessage) {
        StringBuilder temp = new StringBuilder("");
        int prevInt;
        int currentInt;

        if(prevContentBuffer.length() == 0) {
            prevInt = 0;
        } else {
            prevInt = Integer.parseInt(prevContentBuffer.toString());
        }

        currentInt = Integer.parseInt(currentContentMessage.toString());

        if(Integer.MAX_VALUE - (prevInt + currentInt) < 0) {
            if(prevInt > currentInt ) {
                temp.append(Integer.MAX_VALUE);
                prevInt = - (Integer.MAX_VALUE - (prevInt + currentInt));
            } else {
                temp.append(prevInt);
                prevInt = currentInt;
            }
            temp.append("overflow!" + prevInt);
        } else {
            temp.append((prevInt + currentInt));
        }

        return temp;
    }
}

