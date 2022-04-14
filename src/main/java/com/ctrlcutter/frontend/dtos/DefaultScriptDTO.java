package com.ctrlcutter.frontend.dtos;

import java.util.List;

public class DefaultScriptDTO {

    private Long id;
    private String key;
    private List<String> modifierKeys;

    public DefaultScriptDTO() {}

    public DefaultScriptDTO(Long id, String key, List<String> modifierKeys) {
        this.key = key;
        this.modifierKeys = modifierKeys;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
