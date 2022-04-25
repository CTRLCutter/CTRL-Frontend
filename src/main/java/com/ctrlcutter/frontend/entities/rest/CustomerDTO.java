package com.ctrlcutter.frontend.entities.rest;

import java.sql.Timestamp;

public class CustomerDTO {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Timestamp registration_date;

    private SessionDTO session;
    private BackupScriptDTO[] shortcuts;

    public CustomerDTO() {}

    public CustomerDTO(String username, String email, String password, Timestamp registration_date) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registration_date = registration_date;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegistration_date() {
        return this.registration_date;
    }

    public void setRegistration_date(Timestamp registration_date) {
        this.registration_date = registration_date;
    }

    public SessionDTO getSession() {
        return this.session;
    }

    public void setSession(SessionDTO session) {
        this.session = session;
    }

    public BackupScriptDTO[] getShortcuts() {
        return this.shortcuts;
    }

    public void setShortcuts(BackupScriptDTO[] shortcuts) {
        this.shortcuts = shortcuts;
    }
}
