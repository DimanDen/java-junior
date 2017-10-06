package com.acme.edu;
import com.acme.edu.message.*;

class LoggerController {
    private Message prevMessage;
    private Saver saver = new Saver();

    void parseMessage(Message currentMessage) throws LoggerControllerException {
        StringBuilder tempStr = new StringBuilder();

        if(prevMessage == null) {
            tempStr.append("");
        } else {
            if(!currentMessage.isSameType(prevMessage)) {
                prevMessage.concatenateWithPrefix();


                try {
                    saver.save(prevMessage.getContent());
                } catch(SaverException e) {
                    throw new LoggerControllerException("logger controller exception", e);
                }


                tempStr.append("");
            } else {
                tempStr.append(prevMessage.getContent());
            }
        }

        try {
            currentMessage.formatContent(tempStr);
        } catch (IllegalArgumentException | SaverException e) {
            throw new LoggerControllerException("logger controller exception", e);
        }


        prevMessage = currentMessage;
    }
}

class LoggerControllerException extends SaverException {
    LoggerControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
