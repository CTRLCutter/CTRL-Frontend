package com.ctrlcutter.frontend.entities.shortcut;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Shortcut {

    private List<ModifierKey> modifierKeys;
    private BasicKey basicKey;
    private Optional<Long> id;

    public Shortcut(BasicKey basicKey, ModifierKey... modifierKeys) {

        this.basicKey = basicKey;
        this.modifierKeys = Arrays.asList(modifierKeys);
    }

    public Shortcut(BasicKey basicKey, List<ModifierKey> modifierKeys) {
        this.basicKey = basicKey;
        this.modifierKeys = modifierKeys;
        this.id = Optional.empty();
    }

    public BasicKey getBasicKey() {
        return this.basicKey;
    }

    public List<ModifierKey> getModifierKeys() {
        return this.modifierKeys;
    }

    public Optional<Long> getId() {
        return id;
    }

    public void setId(Optional<Long> id) {
        this.id = id;
    }

    public String getStringRepresentation() {
        StringBuilder stringRepresentationBuilder = new StringBuilder();

        stringRepresentationBuilder.append(getModifierKeyStringRepresenation());
        stringRepresentationBuilder.append(this.basicKey.getStringRepresentation());

        return stringRepresentationBuilder.toString();
    }

    private String getModifierKeyStringRepresenation() {
        StringBuilder modifierKeyStringRepresentationBuilder = new StringBuilder();

        for (ModifierKey key : this.modifierKeys) {
            modifierKeyStringRepresentationBuilder.append(key.getStringRepresentation());
            modifierKeyStringRepresentationBuilder.append(" + ");
        }

        return modifierKeyStringRepresentationBuilder.toString();
    }
}
