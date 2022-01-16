package com.ctrlcutter.frontend.views.shortcutcreationform.components;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.ctrlcutter.frontend.entities.shortcut.BasicKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKeys;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyDownEvent;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.textfield.TextField;

public class ShortcutKeyDownListener implements ComponentEventListener<KeyDownEvent> {

    private Set<ModifierKeys> modifierKeyValues = new HashSet<>();
    private Set<ModifierKey> modifierKeys = new HashSet<>();

    private Shortcut currentShortcut;
    private TextField updatedTextField;

    private boolean shortcutResetValue = false;
    private char currentKey;

    public ShortcutKeyDownListener(TextField updatedTextField) {
        this.updatedTextField = updatedTextField;
    }

    @Override
    public void onComponentEvent(KeyDownEvent event) {

        Key eventKey = event.getKey();

        if (Key.isModifier(eventKey)) {

            Iterator<KeyModifier> it = event.getModifiers().iterator();

            shortcutResetValue = false;

            addToModifierKeyValueList(it);

        } else {

            currentKey = eventKey.getKeys().get(0).toCharArray()[0];
            shortcutResetValue = true;
        }

        modifierKeys = new HashSet<>();
        modifierKeyValues.forEach(m -> modifierKeys.add(new ModifierKey(m)));

        Shortcut shortcut = new Shortcut(new BasicKey(currentKey), modifierKeys.stream().collect(Collectors.toList()));

        if (shortcutResetValue) {
            clearModifiers();
        }

        this.currentShortcut = shortcut;
        this.updatedTextField.setValue(shortcut.getStringRepresentation());

    }

    private void addToModifierKeyValueList(Iterator<KeyModifier> iterator) {

        while (iterator.hasNext()) {

            KeyModifier modifier = iterator.next();

            Optional<ModifierKeys> modifierKeyOptional = ModifierKeys.convertModifierKeyFormat(modifier);

            if (modifierKeyOptional.isPresent()) {

                modifierKeyValues.add(modifierKeyOptional.get());
            }
        }
    }

    private void clearModifiers() {

        modifierKeyValues = new HashSet<>();
        modifierKeys = new HashSet<>();
    }

    public Shortcut getCurrentShortcut() {

        return this.currentShortcut;
    }

    protected void clearValues() {

        this.currentKey = Character.MIN_VALUE;
        this.modifierKeyValues = new HashSet<>();
        this.modifierKeys = new HashSet<>();
        this.shortcutResetValue = false;
        this.currentShortcut = null;
    }

}
