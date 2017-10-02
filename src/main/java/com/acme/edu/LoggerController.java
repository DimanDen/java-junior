package com.acme.edu;

class LoggerController {
    private StringBuilder resultBuffer = new StringBuilder("");
    private Message prevMessage;
    private Message currentMessage;

    private IntFormatter intFormatter = new IntFormatter();
    private StringFormatter stringFormatter = new StringFormatter();
    private ByteFormatter byteFormatter = new ByteFormatter();
    private Saver saver = new Saver();

    private void countResultBuffer() {
        String temp = "";
        switch (currentMessage.getContentType().toString()) {
            case "Integer": {
                temp = intFormatter.format(resultBuffer, currentMessage.getContent()).toString();
                break;
            }
            case "String": {
                if (prevMessage != null) {
                    resultBuffer.append("\r\n");
                }
                temp = stringFormatter.format(resultBuffer, currentMessage.getContent()).toString();
                break;
            }
            case "Byte": {
                temp = byteFormatter.format(resultBuffer, currentMessage.getContent()).toString();
                break;
            }
        }

        if(temp.contains("overflow!")) {
            saver.save(resultBuffer);
            resultBuffer.setLength(0);
            resultBuffer.append(temp.substring(temp.lastIndexOf("overflow!") + "overflow!".length()));
        } else {
            resultBuffer.setLength(0);
            resultBuffer.append(temp);
        }
    }

    private void accumulate() {
        if (prevMessage == null
                || prevMessage.getContentType().toString().equals(currentMessage.getContentType().toString())) {
            countResultBuffer();

        } else {
            if(!resultBuffer.toString().equals("")) {
                saver.save(resultBuffer);
            }
            resultBuffer.setLength(0);
            prevMessage = null;
            countResultBuffer();
        }
    }

    private void setCurrentMessage(Message currentMessage) {
        this.currentMessage = currentMessage;
    }

    void parseMessage(Message currentMessage) {
        setCurrentMessage(currentMessage);
        accumulate();
        setPrevMessage(currentMessage);
    }

    void setPrevMessage(Message prevMessage) {
        this.prevMessage = prevMessage;
    }
}
