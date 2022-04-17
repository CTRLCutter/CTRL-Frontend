package com.ctrlcutter.frontend.views.userview;

import com.ctrlcutter.frontend.dtos.SessionUserDTO;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.mainview.MainView;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
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
        Object sessionKey = session.getAttribute("sessionKey");

        // Session ID at this point cannot be null since the check already happed at the initialisation of the redirection button.
        SessionUserDTO sessionUser = RestRequestHelper.retrieveUserInformation((String) sessionKey);

        SidebarLayout sidebarLayout = new SidebarLayout();

        VerticalLayout userInfoLayout = new VerticalLayout();
        H2 headerText = new H2(getTranslation("userview_welcome", sessionUser.getUsername()));
        headerText.addClassName("centeredText");
        headerText.setWidthFull();

        Button logoutButton = generateLogoutButton(session);
        logoutButton.addClassName("userInfoButton");
        Button backupButton = new Button("Backup");
        backupButton.addClassName("userInfoButton");
        Button restoreBackupButton = new Button("Restore Backup");
        restoreBackupButton.addClassName("userInfoButton");
        restoreBackupButton.getStyle().set("color", "red");
        
        Dialog dialog = new Dialog();

        VerticalLayout dialogLayout = createDialogLayout(dialog);
        dialog.add(dialogLayout);
        
        restoreBackupButton.addClickListener(e -> dialog.open());

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("userInfoButtonLayout");
        buttonLayout.add(logoutButton, backupButton, restoreBackupButton);

        userInfoLayout.add(headerText, buttonLayout);

        add(sidebarLayout, userInfoLayout);
    }
    
    private static VerticalLayout createDialogLayout(Dialog dialog) {   
        Paragraph infoText = new Paragraph("Are you sure that you want to restore the backup.");
        Paragraph warningText = new Paragraph("All current data is getting deleted.");
        
        Button cancelButton = new Button("Cancel");
        cancelButton.addClassName("userInfoButton");
        cancelButton.addClickListener(e -> dialog.close());
        Button confirmButton = new Button("Confirm");
        confirmButton.addClassName("userInfoButton");
        confirmButton.addClickListener(e -> dialog.close());
        confirmButton.getStyle().set("color", "green");
        
        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, confirmButton);
        buttonLayout.addClassName("userInfoButtonLayout");

        VerticalLayout dialogLayout = new VerticalLayout(infoText,
                warningText, buttonLayout);
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

        return dialogLayout;
    }

    private Button generateLogoutButton(VaadinSession session) {
        Button logoutButton = new Button(getTranslation("userview_logout"));
        logoutButton.addClickListener(e -> logoutUser(session));

        return logoutButton;
    }

    private void logoutUser(VaadinSession session) {
        session.setAttribute("sessionKey", null);

        VaadinSession.setCurrent(session);
        ViewRedirectionUtility.redirectToView(MainView.class);
    }
}
