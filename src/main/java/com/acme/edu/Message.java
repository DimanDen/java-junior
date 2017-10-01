package com.acme.edu;

class Message {
    private StringBuilder contentType;
    private StringBuilder content;
    private Message prevState;

    StringBuilder getContentType() {
        return contentType;
    }

    void setContentType(StringBuilder contentType) {
        this.contentType = contentType;
    }

    StringBuilder getContent() {
        return content;
    }

    void setContent(StringBuilder content) {
        this.content = content;
    }

    StringBuilder getSequentBuffer() {
        if(prevState != null) {
            this.setContent(this.getPrevState().getContent().append(this.getContent()));
        }
        return new StringBuilder(this.getContent());
    }

    Message getPrevState() {
        return prevState;
    }

    void setPrevState(Message prevState) {
        this.prevState = prevState;
    }
}
