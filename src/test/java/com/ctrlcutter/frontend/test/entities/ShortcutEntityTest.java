package com.ctrlcutter.frontend.test.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.ctrlcutter.frontend.entities.shortcut.BasicKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKeys;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class ShortcutEntityTest {

    @Test
    public void testStringRepresentation() {

        Shortcut testShortcut1 = new Shortcut(new BasicKey('c'));
        Shortcut testShortcut2 = new Shortcut(new BasicKey('f'), new ModifierKey(ModifierKeys.CONTROL));
        Shortcut testShortcut3 = new Shortcut(new BasicKey('o'), new ModifierKey(ModifierKeys.CONTROL), new ModifierKey(ModifierKeys.SHIFT));

        assertEquals("C", testShortcut1.getStringRepresentation());
        assertEquals("Ctrl + F", testShortcut2.getStringRepresentation());
        assertEquals("Ctrl + Shift + O", testShortcut3.getStringRepresentation());

    }

}
