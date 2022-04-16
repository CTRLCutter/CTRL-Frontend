package com.ctrlcutter.frontend.views.shortcutoverviewview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OverviewShortcutType {

    TEXT("Text Shortcut", "SEND", "Outputs: "),
    PROGRAM("Program Shortcut", "RUN", "Runs: ");

    private final String typeLabel;
    private final String commandType;
    private final String actionPrefix;

    private OverviewShortcutType(String typeLabel, String commandType, String actionPrefix) {
        this.typeLabel = typeLabel;
        this.commandType = commandType;
        this.actionPrefix = actionPrefix;
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
        return actionPrefix;
    }
}
