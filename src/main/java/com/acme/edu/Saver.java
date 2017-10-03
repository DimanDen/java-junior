package com.acme.edu;

public class Saver {
    public void save(StringBuilder message) {
        message = checkOutput(message);
        if(!message.toString().equals("")) {
            System.out.println(message.toString());
        }
    }

    private StringBuilder checkOutput(StringBuilder message) {
        String temp = message.toString();
        if(temp.contains("\r\n") && temp.substring(temp.length() - 2).equals("\r\n"))
        {
            message.setLength(temp.length() - 2);
        }
        return message;
    }
}
