package com.ctrlcutter.frontend.views.shortcutoverviewview;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class OverviewShortcut implements IOverviewShortcut {

    private final Shortcut shortcut;
    private final OverviewShortcutType shortcutType;

    public OverviewShortcut(Shortcut shortcut, OverviewShortcutType shortcutType) {
        this.shortcut = shortcut;
        this.shortcutType = shortcutType;
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
        // TODO Auto-generated method stub
        return null;
    }
}
