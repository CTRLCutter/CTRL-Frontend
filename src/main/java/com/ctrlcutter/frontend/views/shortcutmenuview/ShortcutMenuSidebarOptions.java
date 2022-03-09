package com.ctrlcutter.frontend.views.shortcutmenuview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ctrlcutter.frontend.views.settingsview.SettingsView;
import com.ctrlcutter.frontend.views.shortcutselectionview.ShortcutSelectionView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

public enum ShortcutMenuSidebarOptions {

    SHORTCUTS(new Image("icons/keyboardIcon.png", "shortcut icon"), "sidebar_shortcuts", ShortcutMenuView.class),
    CREATE(new Image("icons/createIcon.png", "create icon"), "sidebar_create", ShortcutSelectionView.class),
    SETTINGS(new Image("icons/settingsIcon.png", "settings icon"), "sidebar_settings", SettingsView.class);

    private Image optionIcon;
    private String translationKey;
    private Class<? extends Component> redirectionViewClass;

    private ShortcutMenuSidebarOptions(Image optionIcon, String translationKey, Class<? extends Component> redirectionViewClass) {

        this.optionIcon = optionIcon;
        this.translationKey = translationKey;
        this.redirectionViewClass = redirectionViewClass;
    }

    public Image getOptionIcon() {
        return optionIcon;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public Class<? extends Component> getRedirectionViewClass() {
        return redirectionViewClass;
    }

    public static List<ShortcutMenuSidebarOptions> getAllOtherOptions(ShortcutMenuSidebarOptions... excludedMenuSidebarOptions) {

        List<ShortcutMenuSidebarOptions> allOptions = Arrays.asList(values());
        List<ShortcutMenuSidebarOptions> excludedOptions = Arrays.asList(excludedMenuSidebarOptions);
        List<ShortcutMenuSidebarOptions> filteredOptions = new ArrayList<>();

        for (ShortcutMenuSidebarOptions option : allOptions) {

            if (!excludedOptions.contains(option)) {
                filteredOptions.add(option);
            }
        }

        return filteredOptions;
    }
}
