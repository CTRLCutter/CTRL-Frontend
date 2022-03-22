package com.ctrlcutter.frontend.views.shortcutcreationform.predefinedform;

import com.ctrlcutter.frontend.util.constants.CTRLCutterConstants;
import com.ctrlcutter.frontend.views.shortcutcreationform.components.ShortcutSelector;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;

public class PredefinedShortcutFormComponent extends VerticalLayout {

    public PredefinedShortcutFormComponent() {

        setId("formComponent");

        ShortcutSelector selector = new ShortcutSelector();
        selector.setId("shortcutSelector");

        Select<String> predefinedShortcutSelector = new Select<>();
        predefinedShortcutSelector.setId("predefinedShortcutSelector");
        predefinedShortcutSelector.setItems("Shortcut 1", "Shortcut 2", "Shortcut 3");

        Image confirmButtonIcon = new Image(CTRLCutterConstants.CONFIRM_BUTTON_ICON_FILEPATH, "confirm_icon");
        confirmButtonIcon.setId("confirmButtonIcon");

        Button confirmButton = new Button(confirmButtonIcon);
        confirmButton.addClassName("formConfirmButton");
        confirmButton.setId("programFormConfirmButton");

        confirmButton.addClickListener(e -> {
            Notification.show("Button stub");
        });

        add(predefinedShortcutSelector, selector, confirmButton);
    }
}
