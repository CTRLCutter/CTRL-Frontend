package com.ctrlcutter.frontend.entities.form;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class TextShortcutFormEntity extends AbstractShortcutFormEntity {

    public TextShortcutFormEntity(Shortcut shortcut, String action) {
        super(shortcut, action);
    }

    @Override
    public String getCommand() {
        return "SEND";
    }
}
