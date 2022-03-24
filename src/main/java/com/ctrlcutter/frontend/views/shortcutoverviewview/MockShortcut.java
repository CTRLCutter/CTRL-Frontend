package com.ctrlcutter.frontend.views.shortcutoverviewview;

import com.ctrlcutter.frontend.entities.shortcut.BasicKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKeys;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class MockShortcut implements IOverviewShortcut {

    @Override
    public Shortcut getShortcut() {
        return new Shortcut(new BasicKey('c'), new ModifierKey(ModifierKeys.CONTROL), new ModifierKey(ModifierKeys.SHIFT));
    }

    @Override
    public String getShortcutType() {
        return "Text Shortcut";
    }

    @Override
    public String getShortcutAction() {
        return "Outputs \"Hello World\"";
    }
}
