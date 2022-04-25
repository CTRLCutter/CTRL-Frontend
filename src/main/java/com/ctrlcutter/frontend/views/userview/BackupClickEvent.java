package com.ctrlcutter.frontend.views.userview;

import com.ctrlcutter.frontend.util.provider.SessionKeyProvider;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;

public class BackupClickEvent implements ComponentEventListener<ClickEvent<Button>> {

    private final Dialog dialog;
    private final boolean saveAll;

    public BackupClickEvent(Dialog dialog, boolean saveAll) {
        this.dialog = dialog;
        this.saveAll = saveAll;
    }

    @Override
    public void onComponentEvent(ClickEvent<Button> event) {
        String sessionKey = SessionKeyProvider.getSessionKey();
        boolean backupSuccessful = RestRequestHelper.backupScripts(sessionKey, this.saveAll);
        showBackupNotification(backupSuccessful);
        this.dialog.close();
    }

    private void showBackupNotification(boolean backupSuccessful) {
        if (backupSuccessful) {
            Notification.show("Backup Successful.");
            return;
        }
        Notification.show("Backup Failed.");
    }
}
