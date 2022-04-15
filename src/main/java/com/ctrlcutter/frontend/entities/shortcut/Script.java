package com.ctrlcutter.frontend.entities.shortcut;

import java.util.List;
import java.util.Optional;

public class Script {

    private final Long id;
    private final String os;
    private final String scriptType;

    private final List<Shortcut> shortcuts;
    private Optional<String> command;
    private Optional<List<String>> parameters;
    private Optional<String> predefinedType;

    public Script(List<Shortcut> shortcuts, String os, String scriptType, Long id) {
        this.id = id;
        this.shortcuts = shortcuts;
        this.os = os;
        this.scriptType = scriptType;
        this.command = Optional.empty();
        this.parameters = Optional.empty();
        this.predefinedType = Optional.empty();
    }

    public Long getId() {
        return id;
    }

    public Optional<List<String>> getParameters() {
        return parameters;
    }

    public void setParameters(Optional<List<String>> parameters) {
        this.parameters = parameters;
    }

    public Optional<String> getPredefinedType() {
        return predefinedType;
    }

    public void setPredefinedType(Optional<String> predefinedType) {
        this.predefinedType = predefinedType;
    }

    public String getOs() {
        return os;
    }

    public String getScriptType() {
        return scriptType;
    }

    public List<Shortcut> getShortcuts() {
        return shortcuts;
    }

    public Optional<String> getCommand() {
        return command;
    }

    public void setCommand(Optional<String> command) {
        this.command = command;
    }
}
