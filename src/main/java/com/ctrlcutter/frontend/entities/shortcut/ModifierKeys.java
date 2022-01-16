package com.ctrlcutter.frontend.entities.shortcut;

import java.util.Optional;

import com.vaadin.flow.component.KeyModifier;

public enum ModifierKeys {

    CONTROL("Ctrl"),
    ALT("Alt"),
    SHIFT("Shift");

    private String stringRepresentation;

    private ModifierKeys(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public static Optional<ModifierKeys> convertModifierKeyFormat(KeyModifier key) {

        switch (key) {

            case CONTROL:
                return Optional.of(ModifierKeys.CONTROL);
            case ALT:
                return Optional.of(ModifierKeys.ALT);
            case SHIFT:
                return Optional.of(ModifierKeys.SHIFT);
            default:
                return Optional.empty();
        }
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}
