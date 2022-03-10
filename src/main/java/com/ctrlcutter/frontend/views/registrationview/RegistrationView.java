package com.ctrlcutter.frontend.views.registrationview;

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

    public RegistrationView() {
        setId("registrationView");

        VerticalLayout registrationLayout = new VerticalLayout();
        registrationLayout.setId("registrationLayout");

        HorizontalLayout userInfoRow = new HorizontalLayout();
        userInfoRow.setClassName("registrationFormRow");

        HorizontalLayout passwordRow = new HorizontalLayout();
        passwordRow.setClassName("registrationFormRow");

        H2 header = new H2(getTranslation("registration_form_header"));
        header.setId("registrationHeader");

        TextField usernameField = new TextField();
        usernameField.setLabel(getTranslation("registration_form_username"));
        usernameField.setRequired(true);
        usernameField.setClassName("registrationFormField");

        EmailTextField emailField = new EmailTextField();

        userInfoRow.add(usernameField, emailField);

        RegistrationPasswordField passwordField = new RegistrationPasswordField();

        RegistrationConfirmPasswordField confirmPasswordField = new RegistrationConfirmPasswordField();

        confirmPasswordField.addValueChangeListener(e -> {
            confirmPasswordField.updateConfirmField(passwordField.getValue());
        });

        passwordRow.add(passwordField, confirmPasswordField);

        Button submitButton = new Button(getTranslation("registration_form_submit_btn"));
        submitButton.setId("registrationSubmitButton");

        submitButton.addClickListener(e -> {
            Notification.show("Registration Stub");
        });

        registrationLayout.add(header, userInfoRow, passwordRow, submitButton);
        add(registrationLayout);
    }
}
