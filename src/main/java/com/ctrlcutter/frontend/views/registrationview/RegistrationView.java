package com.ctrlcutter.frontend.views.registrationview;

import com.ctrlcutter.frontend.dtos.RegistrationUserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

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

        submitButton.addClickListener(e -> {
            submitRegistration();
        });

        return submitButton;
    }

    private void submitRegistration() {

        String userNameValue = this.usernameField.getValue();
        String emailValue = this.emailField.getValue();
        String passwordValue = this.passwordField.getValue();

        if (!confirmPasswordField.isConfirmedPasswordEqual()) {
            Notification.show("Values from both password fields are not equal.");
            return;
        }

        RegistrationUserDTO registeredUser = new RegistrationUserDTO(userNameValue, emailValue, passwordValue);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String userJson = mapper.writeValueAsString(registeredUser);
            System.out.println(userJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
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
