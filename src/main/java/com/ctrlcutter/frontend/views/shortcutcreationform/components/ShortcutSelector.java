package com.ctrlcutter.frontend.views.shortcutcreationform.components;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;

public class ShortcutSelector extends CustomField<Shortcut> {

    private Label shortcutLabel;
    private TextField shortcutInputField;
    private ShortcutKeyDownListener keyDownListener;

    public ShortcutSelector() {
        this.shortcutLabel = new Label();

        this.shortcutInputField = new TextField();
        shortcutInputField.setId("shortcutInputField");
        shortcutInputField.setPlaceholder("Enter your Shortcut");

        Button clearButton = new Button("Clear");

        this.keyDownListener = new ShortcutKeyDownListener(shortcutInputField);

        shortcutInputField.addKeyDownListener(keyDownListener);

        clearButton.addClickListener(e -> {
            shortcutInputField.clear();
            keyDownListener.clearValues();
        });

        add(this.shortcutLabel, shortcutInputField, clearButton);
    }

    @Override
    public Shortcut generateModelValue() {
        return this.keyDownListener.getCurrentShortcut();
    }

    @Override
    public void setPresentationValue(Shortcut shortcut) {
        this.keyDownListener.setCurrentShortcut(shortcut);
        this.shortcutInputField.setValue(shortcut.getStringRepresentation());
    }
}
