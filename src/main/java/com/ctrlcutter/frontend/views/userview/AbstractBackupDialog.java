package com.ctrlcutter.frontend.views.userview;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

public abstract class AbstractBackupDialog extends Dialog {

    protected final String buttonClassName = "userInfoButton";

    protected Button generateDialogCancelButton() {
        Button cancelButton = new Button(getTranslation("backup_cancel_button_title"));
        cancelButton.addClassName(buttonClassName);
        cancelButton.addClickListener(e -> close());

        return cancelButton;
    }
}
