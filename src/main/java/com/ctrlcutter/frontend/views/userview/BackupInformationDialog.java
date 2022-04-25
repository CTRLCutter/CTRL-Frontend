package com.ctrlcutter.frontend.views.userview;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BackupInformationDialog extends AbstractBackupDialog {

    public BackupInformationDialog() {
        add(createDialogLayout());
    }

    private VerticalLayout createDialogLayout() {
        Paragraph infoText = new Paragraph(getTranslation("backup_dialog_info_text"));
        HorizontalLayout buttonLayout = generateDialogButtonLayout();
        VerticalLayout dialogLayout = new DialogLayout(infoText, buttonLayout);

        return dialogLayout;
    }

    private HorizontalLayout generateDialogButtonLayout() {
        Button cancelButton = generateDialogCancelButton();
        Button selectRestrictedButton = generateSelectRestrictedButton();
        Button selectAllButton = generateSelectAllButton();
        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, selectRestrictedButton, selectAllButton);
        buttonLayout.addClassName("userInfoButtonLayout");

        return buttonLayout;
    }

    private Button generateSelectRestrictedButton() {
        Button confirmButton = new Button(getTranslation("backup_select_restricted_button_title"));
        confirmButton.addClassName(buttonClassName);
        confirmButton.addClickListener(new BackupClickEvent(this, false));
        confirmButton.getStyle().set("color", "green");

        return confirmButton;
    }

    private Button generateSelectAllButton() {
        Button confirmButton = new Button(getTranslation("backup_select_all_button_title"));
        confirmButton.addClassName(buttonClassName);
        confirmButton.addClickListener(new BackupClickEvent(this, true));
        confirmButton.getStyle().set("color", "green");

        return confirmButton;
    }
}
