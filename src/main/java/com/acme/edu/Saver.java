package com.acme.edu;
import static java.lang.System.lineSeparator;

public class Saver {
    private final String SEPARATOR = "\r\n";
    public void save(StringBuilder message) {
        message = checkOutput(message);
        if(!message.toString().equals("")) {
            System.out.println(message.toString());
        }
    }

    private StringBuilder checkOutput(StringBuilder message) {
        String temp = message.toString();
        if(temp.contains(SEPARATOR) && temp.substring(temp.length() - 2).equals(SEPARATOR))
        {
            message.setLength(temp.length() - 2);
        }
        return message;
    }
}
