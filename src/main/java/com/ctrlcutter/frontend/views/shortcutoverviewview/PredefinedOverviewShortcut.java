package com.ctrlcutter.frontend.views.shortcutoverviewview;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class PredefinedOverviewShortcut implements IOverviewShortcut {

    private final Shortcut shortcut;
    private final String shortcutType;

    public PredefinedOverviewShortcut(Shortcut shortcut, String type) {
        this.shortcut = shortcut;
        this.shortcutType = type;
    }

    @Override
    public Shortcut getShortcut() {
        return this.shortcut;
    }

    @Override
    public String getShortcutType() {
        return this.shortcutType;
    }

    @Override
    public String getShortcutAction() {
        return null;
    }
}
