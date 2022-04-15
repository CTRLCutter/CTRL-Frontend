package com.ctrlcutter.frontend.util.rest;

import java.util.List;

import com.ctrlcutter.frontend.dtos.BasicScriptDTO;
import com.ctrlcutter.frontend.util.rest.exception.ShortcutHelperException;

public class ShortcutHelper {

    public static BasicScriptDTO getShortcutById(Long id) {
        List<BasicScriptDTO> allScripts = RestRequestHelper.getAllScripts();

        for (BasicScriptDTO script : allScripts) {
            if (script.getId() == id) {
                return script;
            }
        }
        throw new ShortcutHelperException("Could not find shortcut with id " + id);
    }
}
