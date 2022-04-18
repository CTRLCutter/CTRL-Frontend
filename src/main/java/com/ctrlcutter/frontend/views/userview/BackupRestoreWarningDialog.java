package com.ctrlcutter.frontend.views.userview;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BackupRestoreWarningDialog extends Dialog {

    private final String buttonClassName = "userInfoButton";

    public BackupRestoreWarningDialog() {
        add(createDialogLayout());
    }

    private VerticalLayout createDialogLayout() {
        Paragraph infoText = new Paragraph(getTranslation("dialog_info_text"));
        Paragraph warningText = new Paragraph(getTranslation("dialog_info_warning"));

        HorizontalLayout buttonLayout = generateDialogButtonLayout();

        VerticalLayout dialogLayout = new VerticalLayout(infoText, warningText, buttonLayout);
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

        return dialogLayout;
    }

    private HorizontalLayout generateDialogButtonLayout() {
        Button cancelButton = generateDialogCancelButton();
        Button confirmButton = generateDialogConfirmButton();
        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, confirmButton);
        buttonLayout.addClassName("userInfoButtonLayout");

        return buttonLayout;
    }

    private Button generateDialogCancelButton() {
        Button cancelButton = new Button(getTranslation("restore_backup_cancel_button_title"));
        cancelButton.addClassName(buttonClassName);
        cancelButton.addClickListener(e -> close());

        return cancelButton;
    }

    private Button generateDialogConfirmButton() {
        Button confirmButton = new Button(getTranslation("restore_backup_confirm_button_title"));
        confirmButton.addClassName(buttonClassName);
        confirmButton.addClickListener(e -> close());
        confirmButton.getStyle().set("color", "green");

        return confirmButton;
    }
}
