package com.ctrlcutter.frontend.util.provider;

import java.util.List;
import java.util.stream.Collectors;

import com.ctrlcutter.frontend.dtos.BasicScriptDTO;
import com.ctrlcutter.frontend.dtos.DefaultScriptDTO;
import com.ctrlcutter.frontend.dtos.PredefinedScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.BasicKey;
import com.ctrlcutter.frontend.entities.shortcut.IShortcutProvider;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKeys;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;

public class ShortcutProvider implements IShortcutProvider {

    @Override
    public List<Shortcut> provideUserShortcuts() {
        List<BasicScriptDTO> basicShortcuts = RestRequestHelper.getAllScripts();
        List<PredefinedScriptDTO> predefinedScripts = RestRequestHelper.getAllPredefinedScripts();

        List<Shortcut> shortcuts = basicShortcuts.stream().map(this::mapScriptDTOToShortcut).collect(Collectors.toList());
        predefinedScripts.forEach(s -> {
            shortcuts.addAll(mapPredefinedScriptDTOToShortcut(s));
        });

        return shortcuts;
    }

    private Shortcut mapScriptDTOToShortcut(BasicScriptDTO scriptDTO) {
        BasicKey basicKey = new BasicKey(scriptDTO.getKey().toCharArray()[0]);
        List<String> modifierKeys = scriptDTO.getModifierKeys();
        List<ModifierKeys> modifierKeyEnumValues = modifierKeys.stream().map(ModifierKeys::getModifierKeyFromString).collect(Collectors.toList());
        List<ModifierKey> modifierKeyValues = modifierKeyEnumValues.stream().map(ModifierKey::new).collect(Collectors.toList());
        Shortcut shortcut = new Shortcut(basicKey, modifierKeyValues);

        return shortcut;
    }

    private List<Shortcut> mapPredefinedScriptDTOToShortcut(PredefinedScriptDTO scriptDTO) {
        List<DefaultScriptDTO> defaultScriptDTO = scriptDTO.getShortcuts();
        List<Shortcut> mappedShortcuts = defaultScriptDTO.stream().map(this::mapDefaultScriptDTOToShortcut).collect(Collectors.toList());
        return mappedShortcuts;
    }

    private Shortcut mapDefaultScriptDTOToShortcut(DefaultScriptDTO scriptDTO) {
        BasicKey basicKey = new BasicKey(scriptDTO.getKey().toCharArray()[0]);
        List<String> modifierKeys = scriptDTO.getModifierKeys();
        List<ModifierKeys> modifierKeyEnumValues = modifierKeys.stream().map(ModifierKeys::getModifierKeyFromString).collect(Collectors.toList());
        List<ModifierKey> modifierKeyValues = modifierKeyEnumValues.stream().map(ModifierKey::new).collect(Collectors.toList());
        Shortcut shortcut = new Shortcut(basicKey, modifierKeyValues);

        return shortcut;
    }
}
