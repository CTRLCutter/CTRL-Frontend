package com.ctrlcutter.frontend.entities.shortcut;

public class ModifierKey implements IKey {

    private ModifierKeys modifierKey;

    public ModifierKey(ModifierKeys modifierKey) {
        this.modifierKey = modifierKey;
    }

    @Override
    public String getStringRepresentation() {
        return this.modifierKey.getStringRepresentation();
    }
}
