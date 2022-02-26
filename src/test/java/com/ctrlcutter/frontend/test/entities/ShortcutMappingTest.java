package com.ctrlcutter.frontend.test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.ctrlcutter.frontend.entities.form.TextShortcutFormEntity;
import com.ctrlcutter.frontend.entities.rest.BasicScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.BasicKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKeys;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.ctrlcutter.frontend.util.OSUtility;
import com.ctrlcutter.frontend.util.ShortcutMapper;

public class ShortcutMappingTest {

    @Test
    public void testDTOMapping() {

        BasicKey basicKey = new BasicKey('F');
        Shortcut shortcut = new Shortcut(basicKey, new ModifierKey(ModifierKeys.CONTROL), new ModifierKey(ModifierKeys.ALT));
        TextShortcutFormEntity shortcutEntity = new TextShortcutFormEntity(shortcut, "Hello World");

        BasicScriptDTO scriptDTO = ShortcutMapper.mapShortcutToDTO(shortcutEntity);

        assertEquals(basicKey.getStringRepresentation(), scriptDTO.getKey());
        assertTrue(compareModifierKeys(shortcut.getModifierKeys(), scriptDTO.getModifierKeys()));
        assertEquals(OSUtility.getUserOperatingSystem(), scriptDTO.getOs());
        assertEquals(shortcutEntity.getCommand(), scriptDTO.getCommand());
        assertEquals(shortcutEntity.getAction(), scriptDTO.getParameters()[0]);
    }

    private boolean compareModifierKeys(List<ModifierKey> modifierKeyList, String[] modifierKeyArray) {

        for (int i = 0; i < modifierKeyList.size(); i++) {

            String stringRepresentation = modifierKeyList.get(i).getStringRepresentation().toUpperCase();
            String arrayValue = modifierKeyArray[i];

            if (!stringRepresentation.equals(arrayValue)) {
                return false;
            }
        }

        return true;
    }

}
