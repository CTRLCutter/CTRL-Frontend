package com.ctrlcutter.frontend.dtos;

import java.util.List;

public class PredefinedScriptDTO {

    private Long id;
    private String os;
    private String scriptType;
    private List<DefaultScriptDTO> shortcuts;

    public PredefinedScriptDTO() {}

    public PredefinedScriptDTO(String os, String scriptType, List<DefaultScriptDTO> shortcuts) {
        this.os = os;
        this.scriptType = scriptType;
        this.shortcuts = shortcuts;
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

    public String getScriptType() {
        return this.scriptType;
    }

    public void setScriptType(String scriptType) {
        this.scriptType = scriptType;
    }

    public List<DefaultScriptDTO> getShortcuts() {
        return this.shortcuts;
    }

    public void setShortcuts(List<DefaultScriptDTO> shortcuts) {
        this.shortcuts = shortcuts;
    }
}
