package com.ctrlcutter.frontend.util;

import java.util.ArrayList;
import java.util.List;

import com.ctrlcutter.frontend.entities.shortcut.BasicKey;
import com.ctrlcutter.frontend.entities.shortcut.IShortcutProvider;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKeys;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class MockShortcutProvider implements IShortcutProvider {

    @Override
    public List<Shortcut> provideUserShortcuts() {

        List<Shortcut> shortcuts = new ArrayList<>();

        shortcuts.add(new Shortcut(new BasicKey('e'), new ModifierKey(ModifierKeys.CONTROL)));
        shortcuts.add(new Shortcut(new BasicKey('h'), new ModifierKey(ModifierKeys.SHIFT), new ModifierKey(ModifierKeys.CONTROL)));
        shortcuts.add(
                new Shortcut(new BasicKey('q'), new ModifierKey(ModifierKeys.SHIFT), new ModifierKey(ModifierKeys.ALT), new ModifierKey(ModifierKeys.CONTROL)));
        shortcuts.add(new Shortcut(new BasicKey('u'), new ModifierKey(ModifierKeys.SHIFT)));
        shortcuts.add(new Shortcut(new BasicKey('x'), new ModifierKey(ModifierKeys.CONTROL), new ModifierKey(ModifierKeys.ALT)));

        return shortcuts;
    }

}
