package com.ctrlcutter.frontend.entities.form;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public interface IFormShortcutEntity {

    Shortcut getShortcut();

    String getAction();

    String getCommand();
    
}
