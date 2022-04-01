package com.ctrlcutter.frontend.views.registrationview;

import com.ctrlcutter.frontend.dtos.RegistrationUserDTO;
import com.ctrlcutter.frontend.dtos.SessionDTO;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@PageTitle("Registration")
@Route(value = "registration")
@CssImport("./themes/ctrlcutter/registrationView.css")
public class RegistrationView extends HorizontalLayout {

    private TextField usernameField;
    private EmailTextField emailField;
    private RegistrationPasswordField passwordField;
    private RegistrationConfirmPasswordField confirmPasswordField;

    public RegistrationView() {
        setId("registrationView");

        VerticalLayout registrationLayout = new VerticalLayout();
        registrationLayout.setId("registrationLayout");

        HorizontalLayout userInfoRow = generateUserInfoRow();
        HorizontalLayout passwordRow = generatePasswordRow();

        H2 header = new H2(getTranslation("registration_form_header"));
        header.setId("registrationHeader");

        Button submitButton = generateSubmitButton();

        registrationLayout.add(header, userInfoRow, passwordRow, submitButton);
        add(registrationLayout);
    }

    private Button generateSubmitButton() {
        Button submitButton = new Button(getTranslation("registration_form_submit_btn"));
        submitButton.setId("registrationSubmitButton");
        submitButton.addClickListener(this::submitRegistration);

        return submitButton;
    }

    private void submitRegistration(ClickEvent<Button> event) {
        String userNameValue = this.usernameField.getValue();
        String emailValue = this.emailField.getValue();
        String passwordValue = this.passwordField.getValue();

        if (isValidRegistration()) {
            
            Button sourceButton = event.getSource();
            sourceButton.setEnabled(false);
            
            RegistrationUserDTO registeredUser = new RegistrationUserDTO(userNameValue, emailValue, passwordValue);
            
            // TODO Handle Registration Error... But can errors happen here??? Thinkk.
            SessionDTO sessionDTO = RestRequestHelper.registerUser(registeredUser);
            
            VaadinSession session = VaadinSession.getCurrent();
            session.setAttribute("sessionKey", sessionDTO.getSessionKey());
            VaadinSession.setCurrent(session);
            ViewRedirectionUtility.redirectToView(ShortcutMenuView.class);
            
            return;
        }
    }

    private boolean isValidRegistration() {
        boolean validPassword = this.passwordField.isPasswordStrongEnough();
        boolean passwordFieldsEqual = this.confirmPasswordField.isConfirmedPasswordEqual();
        boolean usernameFieldValid = !this.usernameField.isInvalid();
        boolean emailFieldValid = !this.emailField.isInvalid();

        if (validPassword && passwordFieldsEqual && usernameFieldValid && emailFieldValid) {
            return true;
        }

        if (!passwordFieldsEqual) {
            Notification.show("Values from both password fields are not equal.");
        }

        return false;
    }

    private HorizontalLayout generateUserInfoRow() {
        HorizontalLayout userInfoRow = new HorizontalLayout();
        userInfoRow.setClassName("registrationFormRow");

        usernameField = new TextField();
        usernameField.setLabel(getTranslation("registration_form_username"));
        usernameField.setRequired(true);
        usernameField.setClassName("registrationFormField");

        emailField = new EmailTextField();

        userInfoRow.add(usernameField, emailField);

        return userInfoRow;
    }

    private HorizontalLayout generatePasswordRow() {
        HorizontalLayout passwordRow = new HorizontalLayout();
        passwordRow.setClassName("registrationFormRow");

        passwordField = new RegistrationPasswordField();
        confirmPasswordField = new RegistrationConfirmPasswordField();

        confirmPasswordField.addValueChangeListener(e -> {
            confirmPasswordField.updateConfirmField(passwordField.getValue());
        });

        passwordRow.add(passwordField, confirmPasswordField);

        return passwordRow;
    }
}
