package com.ctrlcutter.frontend.views.registrationview;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
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
        
        H2 header = new H2("Register");
        header.setId("registrationHeader");
        
        TextField usernameField = new TextField();
        usernameField.setLabel("Username");
        usernameField.setClassName("registrationFormField");
        
        TextField emailField = new TextField();
        emailField.setLabel("E-Mail");
        emailField.setClassName("registrationFormField");
        
        userInfoRow.add(usernameField, emailField);
        
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setClassName("registrationFormField");
        
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setLabel("Confirm Password");
        confirmPasswordField.setClassName("registrationFormField");
        
        passwordRow.add(passwordField, confirmPasswordField);
        
        Button submitButton = new Button("Submit");
        submitButton.setId("registrationSubmitButton");
        
        submitButton.addClickListener(e -> {
            Notification.show("Registration Stub");
        });
        
        registrationLayout.add(header, userInfoRow, passwordRow, submitButton);
        add(registrationLayout);
    }
    
}
