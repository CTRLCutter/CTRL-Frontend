package com.ctrlcutter.frontend.views.shortcutmenuview;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.html.Image;

public enum ShortcutMenuSidebarOptions {

    OVERVIEW(new Image("icons/chartIcon.png", "overview icon"), "sidebar_overview"),
    SHORTCUTS(new Image("icons/keyboardIcon.png", "shortcut icon"), "sidebar_shortcuts"),
    CREATE(new Image("icons/createIcon.png", "create icon"), "sidebar_create"),
    SETTINGS(new Image("icons/settingsIcon.png", "settings icon"), "sidebar_settings");

    private Image optionIcon;
    private String translationKey;

    private ShortcutMenuSidebarOptions(Image optionIcon, String translationKey) {

        this.optionIcon = optionIcon;
        this.translationKey = translationKey;
    }

    public Image getOptionIcon() {
        return optionIcon;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public static List<ShortcutMenuSidebarOptions> getAllOptions() {

        return Arrays.asList(values());
    }

}
