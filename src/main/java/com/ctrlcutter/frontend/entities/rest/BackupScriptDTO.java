package com.ctrlcutter.frontend.entities.rest;

public class BackupScriptDTO {

    private Long id;
    private String command;
    private String keyboardKey;
    private String[] modifierKeys;
    private String[] parameters;

    private CustomerDTO customer;

    public BackupScriptDTO() {}

    public BackupScriptDTO(String command, String keyboardKey, String[] modifierKeys, String[] parameters, CustomerDTO customer) {
        this.command = command;
        this.keyboardKey = keyboardKey;
        this.modifierKeys = modifierKeys;
        this.parameters = parameters;
        this.customer = customer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getKeyboardKey() {
        return this.keyboardKey;
    }

    public void setKeyboardKey(String key) {
        this.keyboardKey = key;
    }

    public String[] getModifierKeys() {
        return this.modifierKeys;
    }

    public void setModifierKeys(String[] modifierKeys) {
        this.modifierKeys = modifierKeys;
    }

    public String[] getParameters() {
        return this.parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public CustomerDTO getCustomer() {
        return this.customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
