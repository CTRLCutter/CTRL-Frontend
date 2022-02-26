package com.ctrlcutter.frontend.entities.form;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public abstract class AbstractShortcutFormEntity implements IFormShortcutEntity {

    private Shortcut shortcut;
    private String action;

    public AbstractShortcutFormEntity(Shortcut shortcut, String action) {

        this.shortcut = shortcut;
        this.action = action;
    }

    @Override
    public Shortcut getShortcut() {
        return this.shortcut;
    }

    @Override
    public String getAction() {
        return this.action;
    }
}
