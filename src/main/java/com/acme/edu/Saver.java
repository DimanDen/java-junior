package com.acme.edu;
import static java.lang.System.lineSeparator;

public class Saver {
    private final String SEPARATOR = "\r\n";
    public void save(StringBuilder message) {
        try {
            message = checkOutput(message);
        } catch (RuntimeException e) {
            message = new StringBuilder("");
        }


        if(!message.toString().equals("")) {
            System.out.println(message.toString());
        }
    }

    private StringBuilder checkOutput(StringBuilder message) throws RuntimeException {
        String temp;

        try {
            temp = message.toString();
        } catch(NullPointerException e) {
            throw new RuntimeException("value is null", e);
        }

        if(temp.contains(SEPARATOR) && temp.substring(temp.length() - 2).equals(SEPARATOR))
        {
            message.setLength(temp.length() - 2);
        }
        return message;
    }
}
