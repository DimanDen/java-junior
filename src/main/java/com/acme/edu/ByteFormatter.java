package com.acme.edu;

public class ByteFormatter implements Formatter{
    @Override
    public StringBuilder format(StringBuilder prevContentBuffer, StringBuilder currentContentMessage) {
        StringBuilder temp = new StringBuilder("");
        byte prevByte;
        byte currentByte;

        if(prevContentBuffer.length() == 0) {
            prevByte = 0;
        } else {
            prevByte = Byte.parseByte(prevContentBuffer.toString());
        }

        currentByte = Byte.parseByte(currentContentMessage.toString());

        if(Byte.MAX_VALUE - (prevByte + currentByte) < 0) {
            if(prevByte > currentByte ) {
                temp.append(Byte.MAX_VALUE);
                prevByte = (byte) - (Byte.MAX_VALUE - (prevByte + currentByte));
            } else {
                temp.append(prevByte);
                prevByte = currentByte;
            }
            temp.append("overflow!" + prevByte);
        }
        else {
            temp.append((byte)(prevByte + currentByte));
        }

        return temp;
    }
}

