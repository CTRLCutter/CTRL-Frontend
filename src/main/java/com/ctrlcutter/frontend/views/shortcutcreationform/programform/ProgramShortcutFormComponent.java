package com.ctrlcutter.frontend.views.shortcutcreationform.programform;

import java.util.Objects;

import com.ctrlcutter.frontend.entities.form.IFormShortcutEntity;
import com.ctrlcutter.frontend.entities.form.ProgramShortcutFormEntity;
import com.ctrlcutter.frontend.entities.rest.BasicScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.ctrlcutter.frontend.util.constants.CTRLCutterConstants;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.ctrlcutter.frontend.util.rest.ShortcutMapper;
import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.shortcutcreationform.components.ShortcutSelector;
import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileBuffer;

public class ProgramShortcutFormComponent extends VerticalLayout {

    private String programFilePath;
    private ShortcutSelector selector;

    public ProgramShortcutFormComponent() {

        setId("formComponent");

        this.selector = new ShortcutSelector();
        selector.setId("shortcutSelector");

        // TODO PROBLEM!!! THIS ONLY CREATES A TEMPORARY FILE IN THE CACHE... EVEN CREATING A CUSTOM FILE BUFFER DOESNT FIX IT... I CAN ONLY GET THE FILENAME... JS BASED SOLUTION???
        FileBuffer buffer = new FileBuffer();
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

        fileSelector.addSucceededListener(e -> {
            this.programFilePath = e.getFileName();
        });

        Image confirmButtonIcon = new Image(CTRLCutterConstants.CONFIRM_BUTTON_ICON_FILEPATH, "confirm_icon");
        confirmButtonIcon.setId("confirmButtonIcon");

        Button confirmButton = new Button(confirmButtonIcon);
        confirmButton.addClassName("formConfirmButton");
        confirmButton.setId("programFormConfirmButton");

        confirmButton.addClickListener(e -> {
            requestShortcut();
        });

        add(fileSelector, selector, confirmButton);
    }

    private void requestShortcut() {
        Shortcut selectedShortcut = Objects.requireNonNull(this.selector.generateModelValue());
        String programFilePath = Objects.requireNonNull(this.programFilePath);

        if (!programFilePath.equals("")) {
            IFormShortcutEntity shortcutEntity = new ProgramShortcutFormEntity(selectedShortcut, programFilePath);
            BasicScriptDTO scriptDTO = ShortcutMapper.mapShortcutToDTO(shortcutEntity);
            RestRequestHelper.makeShortcutRESTRequest(scriptDTO);
            ViewRedirectionUtility.redirectToView(ShortcutMenuView.class);
        }
    }
}
