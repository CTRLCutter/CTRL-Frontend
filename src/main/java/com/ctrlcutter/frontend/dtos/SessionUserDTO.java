package com.ctrlcutter.frontend.dtos;

public class SessionUserDTO {

    private int id;
    private String username;
    private String email;
    private String registration_date;

    public SessionUserDTO() {

    }

    public SessionUserDTO(int id, String username, String email, String registration_date) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.registration_date = registration_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}
