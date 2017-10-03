package com.acme.edu;
import com.acme.edu.message.*;

class LoggerController {
    private Message prevMessage;
    private Saver saver = new Saver();

    void parseMessage(Message currentMessage) {
        StringBuilder tempStr = new StringBuilder();

        if(prevMessage == null) {
            tempStr.append("");
        } else {
            if(!currentMessage.isSameType(prevMessage)) {
                prevMessage.concatenateWithPrefix();
                saver.save(prevMessage.getContent());
                tempStr.append("");
            } else {
                tempStr.append(prevMessage.getContent());
            }
        }
        currentMessage.formatContent(tempStr);
        prevMessage = currentMessage;
    }
}
