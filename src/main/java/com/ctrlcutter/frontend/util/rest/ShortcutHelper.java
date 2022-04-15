package com.ctrlcutter.frontend.util.rest;

import java.util.List;

import com.ctrlcutter.frontend.dtos.BasicScriptDTO;
import com.ctrlcutter.frontend.dtos.PredefinedScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
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

    public static PredefinedScriptDTO getPredefinedShortcutById(Long id) {
        List<PredefinedScriptDTO> allScripts = RestRequestHelper.getAllPredefinedScripts();

        for (PredefinedScriptDTO script : allScripts) {
            if (script.getId() == id) {
                return script;
            }
        }
        throw new ShortcutHelperException("Could not find predefined shortcut with id " + id);
    }

    public static Shortcut getShortcutById(List<Shortcut> shortcuts, Long id) {
        for (Shortcut shortcut : shortcuts) {
            if (shortcut.getId().get() == id) {
                return shortcut;
            }
        }

        throw new ShortcutHelperException("Could not find shortcut with id " + id);
    }
}
