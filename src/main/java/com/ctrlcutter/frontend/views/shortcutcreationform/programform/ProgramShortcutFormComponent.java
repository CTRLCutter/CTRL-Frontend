package com.ctrlcutter.frontend.views.shortcutcreationform.programform;

import com.ctrlcutter.frontend.util.constants.CTRLCutterConstants;
import com.ctrlcutter.frontend.views.shortcutcreationform.components.ShortcutSelector;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

public class ProgramShortcutFormComponent extends VerticalLayout {

    public ProgramShortcutFormComponent() {

        setId("formComponent");

        ShortcutSelector selector = new ShortcutSelector();
        selector.setId("shortcutSelector");

        MemoryBuffer buffer = new MemoryBuffer();

        Upload fileSelector = new Upload(buffer);
        fileSelector.setId("fileSelector");
        fileSelector.setDropAllowed(false);

        // TODO Make that dependent of the current OS and their file types. :)
        fileSelector.setAcceptedFileTypes(".exe");

        fileSelector.addFileRejectedListener(event -> {
            String errorMessage = event.getErrorMessage();

            Notification notification = Notification.show(errorMessage, 5000, Notification.Position.MIDDLE);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });

        Image confirmButtonIcon = new Image(CTRLCutterConstants.CONFIRM_BUTTON_ICON_FILEPATH, "confirm_icon");
        confirmButtonIcon.setId("confirmButtonIcon");

        Button confirmButton = new Button(confirmButtonIcon);
        confirmButton.addClassName("formConfirmButton");
        confirmButton.setId("programFormConfirmButton");

        confirmButton.addClickListener(e -> {
            Notification.show("Button stub");
        });

        add(fileSelector, selector, confirmButton);
    }

}
