package com.ctrlcutter.frontend.dtos;

import java.util.List;

public class BasicScriptDTO {

    private Long id;

    private String os;

    private String command;

    private String key;

    private List<String> modifierKeys;

    private List<String> parameters;

    public BasicScriptDTO() {

    }

    public BasicScriptDTO(String os, String command, String key, List<String> modifierKeys, List<String> parameters) {
        this.os = os;
        this.command = command;
        this.key = key;
        this.modifierKeys = modifierKeys;
        this.parameters = parameters;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getModifierKeys() {
        return this.modifierKeys;
    }

    public void setModifierKeys(List<String> modifierKeys) {
        this.modifierKeys = modifierKeys;
    }

    public List<String> getParameters() {
        return this.parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }
}
