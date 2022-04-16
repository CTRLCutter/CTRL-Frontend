package com.ctrlcutter.frontend.util.provider;

import java.util.List;
import java.util.stream.Collectors;

import com.ctrlcutter.frontend.dtos.BasicScriptDTO;
import com.ctrlcutter.frontend.dtos.PredefinedScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.IShortcutProvider;
import com.ctrlcutter.frontend.entities.shortcut.Script;
import com.ctrlcutter.frontend.util.mapper.ScriptMapper;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;

public class ShortcutProvider implements IShortcutProvider {

    @Override
    public List<Script> provideUserScripts() {
        List<BasicScriptDTO> basicShortcuts = RestRequestHelper.getAllScripts();
        List<PredefinedScriptDTO> predefinedScripts = RestRequestHelper.getAllPredefinedScripts();
        List<Script> userScripts = basicShortcuts.stream().map(ScriptMapper::mapBasicScriptToScript).collect(Collectors.toList());

        predefinedScripts.forEach(script -> userScripts.add(ScriptMapper.mapPredefinedScriptToScript(script)));

        return userScripts;
    }
}
