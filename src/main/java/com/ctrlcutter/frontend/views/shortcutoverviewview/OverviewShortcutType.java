package com.ctrlcutter.frontend.views.shortcutoverviewview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctrlcutter.frontend.views.shortcuteditform.programform.ProgramShortcutEditForm;
import com.ctrlcutter.frontend.views.shortcuteditform.textform.TextShortcutEditForm;
import com.vaadin.flow.component.Component;

public enum OverviewShortcutType {

    TEXT("Text Shortcut", "SEND", "Outputs: ", TextShortcutEditForm.class),
    PROGRAM("Program Shortcut", "RUN", "Runs: ", ProgramShortcutEditForm.class);

    private final String typeLabel;
    private final String commandType;
    private final String actionPrefix;
    private final Class<? extends Component> editView;

    private OverviewShortcutType(String typeLabel, String commandType, String actionPrefix, Class<? extends Component> editView) {
        this.typeLabel = typeLabel;
        this.commandType = commandType;
        this.actionPrefix = actionPrefix;
        this.editView = editView;
    }

    public static OverviewShortcutType getShortcutTypeByCommand(String commandType) {
        List<OverviewShortcutType> allShortcutTypes = List.of(values());
        Map<String, OverviewShortcutType> commandTypes = new HashMap<>();

        allShortcutTypes.forEach(type -> commandTypes.put(type.getCommandType(), type));

        return commandTypes.get(commandType);
    }

    public String getTypeLabel() {
        return this.typeLabel;
    }

    public String getCommandType() {
        return this.commandType;
    }

    public String getActionPrefix() {
        return this.actionPrefix;
    }

    public Class<? extends Component> getEditView() {
        return this.editView;
    }
}
