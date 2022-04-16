package com.ctrlcutter.frontend.util.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ctrlcutter.frontend.dtos.BasicScriptDTO;
import com.ctrlcutter.frontend.dtos.DefaultScriptDTO;
import com.ctrlcutter.frontend.dtos.PredefinedScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.BasicKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKeys;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class ShortcutMapper {

    public static Shortcut mapScriptDTOToShortcut(BasicScriptDTO scriptDTO) {
        BasicKey basicKey = new BasicKey(scriptDTO.getKey().toCharArray()[0]);
        List<String> modifierKeys = scriptDTO.getModifierKeys();
        List<ModifierKeys> modifierKeyEnumValues = modifierKeys.stream().map(ModifierKeys::getModifierKeyFromString).collect(Collectors.toList());
        List<ModifierKey> modifierKeyValues = modifierKeyEnumValues.stream().map(ModifierKey::new).collect(Collectors.toList());
        Shortcut shortcut = new Shortcut(basicKey, modifierKeyValues);

        return shortcut;
    }

    public static Shortcut mapDefaultScriptDTOToShortcut(DefaultScriptDTO scriptDTO) {
        BasicKey basicKey = new BasicKey(scriptDTO.getKey().toCharArray()[0]);
        List<String> modifierKeys = scriptDTO.getModifierKeys();
        List<ModifierKeys> modifierKeyEnumValues = modifierKeys.stream().map(ModifierKeys::getModifierKeyFromString).collect(Collectors.toList());
        List<ModifierKey> modifierKeyValues = modifierKeyEnumValues.stream().map(ModifierKey::new).collect(Collectors.toList());
        Shortcut shortcut = new Shortcut(basicKey, modifierKeyValues);
        shortcut.setId(Optional.of(scriptDTO.getId()));

        return shortcut;
    }
    
    public static List<Shortcut> mapPredefinedScriptDTOToShortcut(PredefinedScriptDTO scriptDTO) {
        List<DefaultScriptDTO> defaultScriptDTO = scriptDTO.getShortcuts();
        List<Shortcut> mappedShortcuts = defaultScriptDTO.stream().map(ShortcutMapper::mapDefaultScriptDTOToShortcut).collect(Collectors.toList());

        return mappedShortcuts;
    }  
}
