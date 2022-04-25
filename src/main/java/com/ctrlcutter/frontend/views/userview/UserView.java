package com.ctrlcutter.frontend.views.userview;

import com.ctrlcutter.frontend.dtos.SessionUserDTO;
import com.ctrlcutter.frontend.util.provider.SessionKeyProvider;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.mainview.MainView;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@PageTitle("UserInfo")
@Route(value = "userInfo")
@CssImport("./themes/ctrlcutter/userInfo.css")
public class UserView extends HorizontalLayout {

    public UserView() {
        setId("userView");

        VaadinSession session = VaadinSession.getCurrent();
        String sessionKey = SessionKeyProvider.getSessionKey();

        // Session ID at this point cannot be null since the check already happed at the initialisation of the redirection button.
        SessionUserDTO sessionUser = RestRequestHelper.retrieveUserInformation(sessionKey);

        SidebarLayout sidebarLayout = new SidebarLayout();

        VerticalLayout userInfoLayout = new VerticalLayout();
        H2 headerText = generateHeaderText(sessionUser.getUsername());

        Dialog dialog = new BackupRestoreWarningDialog();
        HorizontalLayout buttonLayout = generateButtonLayout(session, dialog);

        userInfoLayout.add(headerText, buttonLayout);

        add(sidebarLayout, userInfoLayout);
    }

    private H2 generateHeaderText(String sessionUserName) {
        H2 headerText = new H2(getTranslation("userview_welcome", sessionUserName));
        headerText.addClassName("centeredText");
        headerText.setWidthFull();

        return headerText;
    }

    private HorizontalLayout generateButtonLayout(VaadinSession session, Dialog dialog) {
        Button logoutButton = generateLogoutButton(session);

        Dialog backupDialog = new BackupInformationDialog();

        Button backupButton = new Button(getTranslation("userview_backup_button"));
        backupButton.addClassName("userInfoButton");
        backupButton.addClickListener(e -> backupDialog.open());

        Button restoreBackupButton = generateRestoreBackupButton(dialog);

        HorizontalLayout buttonLayout = new HorizontalLayout(logoutButton, backupButton, restoreBackupButton);
        buttonLayout.addClassName("userInfoButtonLayout");

        return buttonLayout;
    }

    private Button generateLogoutButton(VaadinSession session) {
        Button logoutButton = new Button(getTranslation("userview_logout"));
        logoutButton.addClassName("userInfoButton");
        logoutButton.addClickListener(e -> logoutUser(session));

        return logoutButton;
    }

    private void logoutUser(VaadinSession session) {
        session.setAttribute("sessionKey", null);

        VaadinSession.setCurrent(session);
        ViewRedirectionUtility.redirectToView(MainView.class);
    }

    private Button generateRestoreBackupButton(Dialog dialog) {
        Button restoreBackupButton = new Button(getTranslation("userview_restore_button"));
        restoreBackupButton.addClassName("userInfoButton");
        restoreBackupButton.getStyle().set("color", "red");
        restoreBackupButton.addClickListener(e -> dialog.open());

        return restoreBackupButton;
    }
}
