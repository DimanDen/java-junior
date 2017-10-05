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

        try {
            currentMessage.formatContent(tempStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Значение для журналирования является");
            System.out.println("некорректным для данного типа.");
            System.out.println("Суммирование проводится не будет");
        }


        prevMessage = currentMessage;
    }
}
