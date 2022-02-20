package com.ctrlcutter.frontend.views.registrationview;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Registration")
@Route(value = "registration")
@CssImport("./themes/ctrlcutter/registrationView.css")
public class RegistrationView extends HorizontalLayout {

    private Span passwordStrengthText;
    private Icon checkIcon;
    private Icon confirmCheckIcon;
    private Icon emailCheckIcon;

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

        TextField emailField = new TextField();
        emailField.setLabel(getTranslation("registration_form_email"));
        emailField.setRequired(true);

        // Email Regex'es are fun.
        emailField.setPattern(
                "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        emailField.setClassName("registrationFormField");

        emailCheckIcon = VaadinIcon.CHECK.create();
        emailCheckIcon.setVisible(false);
        emailField.setSuffixComponent(emailCheckIcon);

        emailField.setValueChangeMode(ValueChangeMode.EAGER);
        emailField.addValueChangeListener(e -> {
            emailCheckIcon.setVisible(!emailField.isInvalid());
        });

        userInfoRow.add(usernameField, emailField);

        PasswordField passwordField = new PasswordField();
        passwordField.setLabel(getTranslation("registration_form_password"));
        passwordField.setRequired(true);
        passwordField.setClassName("registrationFormField");

        Div passwordStrength = new Div();
        passwordStrengthText = new Span();
        passwordStrength.add(new Text(getTranslation("registration_pass_policy_strength") + " "), passwordStrengthText);
        passwordField.setHelperComponent(passwordStrength);

        checkIcon = VaadinIcon.CHECK.create();
        checkIcon.setVisible(false);
        passwordField.setSuffixComponent(checkIcon);

        passwordField.setValueChangeMode(ValueChangeMode.EAGER);
        passwordField.addValueChangeListener(e -> {
            String password = e.getValue();
            updateHelper(password);
        });

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setLabel(getTranslation("registration_form_confirm_password"));
        confirmPasswordField.setRequired(true);
        confirmPasswordField.setClassName("registrationFormField");

        confirmCheckIcon = VaadinIcon.CHECK.create();
        confirmCheckIcon.setVisible(false);
        confirmPasswordField.setSuffixComponent(confirmCheckIcon);

        confirmPasswordField.setValueChangeMode(ValueChangeMode.EAGER);
        confirmPasswordField.addValueChangeListener(e -> {
            String originalPassword = passwordField.getValue();
            String confirmedPassword = e.getValue();
            confirmCheckIcon.setVisible(false);

            if (originalPassword.equals(confirmedPassword)) {
                confirmCheckIcon.setVisible(true);
            }
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

    private void updateHelper(String password) {

        PasswordStrength passStrength = new PasswordStrength(password);
        PasswordPolicy policy = passStrength.getPasswordPolicy();

        passwordStrengthText.setText(getTranslation(policy.getTranslationkey()));
        passwordStrengthText.getStyle().set("color", policy.getTextColor());
        checkIcon.setVisible(policy.isIconVisibility());
    }
}
