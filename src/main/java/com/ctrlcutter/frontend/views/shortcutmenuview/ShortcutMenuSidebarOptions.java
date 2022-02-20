package com.ctrlcutter.frontend.views.shortcutmenuview;

import java.util.Arrays;
import java.util.List;

import com.ctrlcutter.frontend.views.shortcutselectionview.ShortcutSelectionView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

public enum ShortcutMenuSidebarOptions {

    OVERVIEW(new Image("icons/chartIcon.png", "overview icon"), "sidebar_overview", ShortcutSelectionView.class),
    SHORTCUTS(new Image("icons/keyboardIcon.png", "shortcut icon"), "sidebar_shortcuts", ShortcutSelectionView.class),
    CREATE(new Image("icons/createIcon.png", "create icon"), "sidebar_create", ShortcutSelectionView.class),
    SETTINGS(new Image("icons/settingsIcon.png", "settings icon"), "sidebar_settings", ShortcutSelectionView.class);

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

    public static List<ShortcutMenuSidebarOptions> getAllOptions() {

        return Arrays.asList(values());
    }

}
