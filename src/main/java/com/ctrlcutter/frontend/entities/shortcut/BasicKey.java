package com.ctrlcutter.frontend.entities.shortcut;

import com.vaadin.flow.component.Key;

public class BasicKey implements IKey {

    private Key basicKey;

    public BasicKey(int keyValue) {
        this.basicKey = Key.of(String.valueOf(keyValue));
    }

    public BasicKey(char key) {
        this.basicKey = Key.of(String.valueOf(key));
    }

    public BasicKey(Key key) {
        this.basicKey = key;
    }

    @Override
    public String getStringRepresentation() {

        return (this.basicKey != null) ? this.basicKey.getKeys().get(0).toUpperCase() : "";
    }

}
