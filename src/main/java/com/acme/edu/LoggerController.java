package com.acme.edu;

class LoggerController {
    private StringBuilder resultBuffer;
    private Message prevMessage;
    private Message currentMessage;


    Message getCurrentMessage() {
        return currentMessage;
    }

    void setCurrentMessage(Message currentMessage) {
        this.currentMessage = currentMessage;

        if(prevMessage != null) {
            currentMessage.setPrevState(prevMessage);
        }

        resultBuffer = new StringBuilder(currentMessage.getSequentBuffer());
        sentBufferToPrint();
    }


    StringBuilder getResultBuffer() {
        return resultBuffer;
    }

    void setResultBuffer(StringBuilder resultBuffer) {
        this.resultBuffer = resultBuffer;
        this.prevMessage = currentMessage;
    }

    void sentBufferToPrint() {
        Printer printer = new Printer();
        printer.print(resultBuffer);
    }

}
