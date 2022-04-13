package com.ctrlcutter.frontend.entities.form;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class ProgramShortcutFormEntity extends AbstractShortcutFormEntity {

    public ProgramShortcutFormEntity(Shortcut shortcut, String action) {
        super(shortcut, action);
    }

    @Override
    public String getCommand() {
        return "RUN";
    }
}
