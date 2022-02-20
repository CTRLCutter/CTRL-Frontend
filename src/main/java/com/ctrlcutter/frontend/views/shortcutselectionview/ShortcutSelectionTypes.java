package com.ctrlcutter.frontend.views.shortcutselectionview;

import java.util.Arrays;
import java.util.List;

public enum ShortcutSelectionTypes {

    TEXT,
    PROGRAM;

    public static List<ShortcutSelectionTypes> getAllTypes() {
        return Arrays.asList(values());
    }
}
