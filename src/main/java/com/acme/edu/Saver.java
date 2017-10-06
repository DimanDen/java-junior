package com.acme.edu;
import com.acme.edu.Exceptions.SaverException;

import static java.lang.System.lineSeparator;

public class Saver {
    private final String SEPARATOR = lineSeparator();

    public void save(StringBuilder message)throws SaverException {
        try {
            message = checkOutput(message);
        } catch (SaverException e) {
            throw new SaverException("save exception", e);
        }

        if(!message.toString().equals("")) {
            System.out.println(message.toString());
        }
    }

    private StringBuilder checkOutput(StringBuilder message) throws SaverException {
        String temp;

        if(message != null) {
            try {
                temp = message.toString();
                if(temp.contains(SEPARATOR) && temp.substring(temp.length() - 2).equals(SEPARATOR))
                {
                    message.setLength(temp.length() - 2);
                }
            } catch (Exception e) {
                throw new SaverException("checkout save exception", e);
            }
        } else {
            message = new StringBuilder(message.toString());
        }
        return message;
    }
}

