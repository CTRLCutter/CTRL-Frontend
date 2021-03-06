package com.ctrlcutter.frontend.util.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ctrlcutter.frontend.dtos.BasicScriptDTO;
import com.ctrlcutter.frontend.dtos.PredefinedScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.BasicKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKey;
import com.ctrlcutter.frontend.entities.shortcut.ModifierKeys;
import com.ctrlcutter.frontend.entities.shortcut.Script;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;

public class ScriptMapper {

    public static Script mapBasicScriptToScript(BasicScriptDTO scriptDTO) {
        BasicKey basicKey = new BasicKey(scriptDTO.getKey().toCharArray()[0]);
        List<String> modifierKeys = scriptDTO.getModifierKeys();
        List<ModifierKeys> modifierKeyEnumValues = modifierKeys.stream().map(ModifierKeys::getModifierKeyFromString).collect(Collectors.toList());
        List<ModifierKey> modifierKeyValues = modifierKeyEnumValues.stream().map(ModifierKey::new).collect(Collectors.toList());
        Shortcut shortcut = new Shortcut(basicKey, modifierKeyValues);

        Script script = new Script(List.of(shortcut), scriptDTO.getOs(), "basic", scriptDTO.getId());
        script.setParameters(Optional.of(scriptDTO.getParameters()));
        script.setCommand(Optional.of(scriptDTO.getCommand()));

        return script;
    }

    public static Script mapPredefinedScriptToScript(PredefinedScriptDTO scriptDTO) {
        List<Shortcut> shortcuts = ShortcutMapper.mapPredefinedScriptDTOToShortcut(scriptDTO);
        Script script = new Script(shortcuts, scriptDTO.getOs(), "predefined", scriptDTO.getId());
        script.setPredefinedType(Optional.of(scriptDTO.getScriptType()));

        return script;
    }
}
