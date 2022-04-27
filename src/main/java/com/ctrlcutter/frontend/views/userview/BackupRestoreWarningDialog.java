package com.ctrlcutter.frontend.views.userview;

import com.ctrlcutter.frontend.util.provider.SessionKeyProvider;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BackupRestoreWarningDialog extends AbstractBackupDialog {

    public BackupRestoreWarningDialog() {
        add(createDialogLayout());
    }

    private VerticalLayout createDialogLayout() {
        Paragraph infoText = new Paragraph(getTranslation("restore_dialog_info_text"));
        Paragraph warningText = new Paragraph(getTranslation("restore_dialog_info_warning"));
        HorizontalLayout buttonLayout = generateDialogButtonLayout();
        VerticalLayout dialogLayout = new DialogLayout(infoText, warningText, buttonLayout);

        return dialogLayout;
    }

    private HorizontalLayout generateDialogButtonLayout() {
        Button cancelButton = generateDialogCancelButton();
        Button confirmButton = generateDialogConfirmButton();
        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, confirmButton);
        buttonLayout.addClassName("userInfoButtonLayout");

        return buttonLayout;
    }

    private Button generateDialogConfirmButton() {
        Button confirmButton = new Button(getTranslation("restore_backup_confirm_button_title"));
        confirmButton.addClassName(buttonClassName);
        confirmButton.addClickListener(e -> {
            String sessionKey = SessionKeyProvider.getSessionKey();
            RestRequestHelper.retrieveBackup(sessionKey);
            close();
        });
        confirmButton.getStyle().set("color", "green");

        return confirmButton;
    }
}
