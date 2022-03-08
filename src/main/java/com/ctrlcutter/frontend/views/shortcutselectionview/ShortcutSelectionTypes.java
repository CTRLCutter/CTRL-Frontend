package com.ctrlcutter.frontend.views.shortcutselectionview;

import java.util.Arrays;
import java.util.List;

import com.ctrlcutter.frontend.views.shortcutcreationform.programform.ProgramShortcutCreationForm;
import com.ctrlcutter.frontend.views.shortcutcreationform.textform.TextShortcutCreationForm;
import com.vaadin.flow.component.Component;

public enum ShortcutSelectionTypes {

    TEXT(TextShortcutCreationForm.class),
    PROGRAM(ProgramShortcutCreationForm.class);

    private Class<? extends Component> shortcutFormView;

    private ShortcutSelectionTypes(Class<? extends Component> shortcutFormView) {
        this.shortcutFormView = shortcutFormView;
    }

    public Class<? extends Component> getShortcutFormView() {
        return this.shortcutFormView;
    }

    public static List<ShortcutSelectionTypes> getAllTypes() {
        return Arrays.asList(values());
    }
}
