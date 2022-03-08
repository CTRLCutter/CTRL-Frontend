package com.ctrlcutter.frontend.views.shortcutcreationform.programform;

import com.ctrlcutter.frontend.views.shortcutcreationform.components.ShortcutSelector;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.UploadI18N;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

public class ProgramShortcutFormComponent extends VerticalLayout {

    private ShortcutSelector selector;

    public ProgramShortcutFormComponent() {

        setId("formComponent");

        this.selector = new ShortcutSelector();
        selector.setId("shortcutSelector");

        MemoryBuffer buffer = new MemoryBuffer();
        
        // TODO Change fileSelector button text...
        
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

        add(fileSelector, selector);
    }

}
