package com.ctrlcutter.frontend.views.shortcutmenuview;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.html.Image;

public enum ShortcutMenuSidebarOptions {

    OVERVIEW(new Image(), "sidebar_overview"),
    SHORTCUTS(new Image(), "sidebar_shortcuts"),
    CREATE(new Image(), "sidebar_create"),
    SETTINGS(new Image(), "sidebar_settings");

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
