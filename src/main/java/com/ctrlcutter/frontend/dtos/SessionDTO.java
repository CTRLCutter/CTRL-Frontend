package com.ctrlcutter.frontend.dtos;

public class SessionDTO {

    private String sessionKey;

    public SessionDTO() {

    }

    public SessionDTO(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
