package com.ctrlcutter.frontend.views.shortcutoverviewview;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public interface IOverviewShortcut {

    Shortcut getShortcut();
    
    String getShortcutType();
    
    String getShortcutAction();
}
