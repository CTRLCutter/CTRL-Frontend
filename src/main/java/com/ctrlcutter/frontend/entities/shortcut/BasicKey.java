package com.ctrlcutter.frontend.entities.shortcut;

public class BasicKey implements IKey {

    private char basicKey;

    public BasicKey(int keyValue) {
        this.basicKey = (char) keyValue;
    }

    public BasicKey(char key) {
        this.basicKey = key;
    }

    @Override
    public String getStringRepresentation() {

        return String.valueOf(this.basicKey).toUpperCase();
    }

}
