package com.acme.edu;

class Message {
    private StringBuilder contentType;
    private StringBuilder content;

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
}
