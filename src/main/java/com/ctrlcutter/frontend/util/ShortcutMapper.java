package com.ctrlcutter.frontend.util;

import java.util.List;

import com.ctrlcutter.frontend.entities.form.IFormShortcutEntity;
import com.ctrlcutter.frontend.entities.rest.BasicScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKey;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class ShortcutMapper {

    public static BasicScriptDTO mapShortcutToDTO(IFormShortcutEntity shortcutEntity) {

        BasicScriptDTO scriptDTO = new BasicScriptDTO();
        Shortcut shortcut = shortcutEntity.getShortcut();
        List<ModifierKey> modifierKeyList = shortcut.getModifierKeys();
        String[] modifierKeys = new String[modifierKeyList.size()];

        for (int i = 0; i < modifierKeyList.size(); i++) {

            ModifierKey key = modifierKeyList.get(i);
            modifierKeys[i] = key.getStringRepresentation().toUpperCase();
        }

        scriptDTO.setKey(shortcut.getBasicKey().getStringRepresentation());
        scriptDTO.setModifierKeys(modifierKeys);

        scriptDTO.setParameters(new String[] {shortcutEntity.getAction()});
        scriptDTO.setCommand(shortcutEntity.getCommand());
        scriptDTO.setOs(OSUtility.getUserOperatingSystem());

        return scriptDTO;
    }

}
