package com.ctrlcutter.frontend.views.shortcutoverviewview;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class OverviewShortcut implements IOverviewShortcut {

    private final Shortcut shortcut;
    private final OverviewShortcutType shortcutType;
    private String action;

    public OverviewShortcut(Shortcut shortcut, OverviewShortcutType shortcutType, String action) {
        this.shortcut = shortcut;
        this.shortcutType = shortcutType;
        this.action = action;
    }

    @Override
    public Shortcut getShortcut() {
        return this.shortcut;
    }

    @Override
    public String getShortcutType() {
        return this.shortcutType.getTypeLabel();
    }

    @Override
    public String getShortcutAction() {
        return this.shortcutType.getActionPrefix() + this.action;
    }
}
