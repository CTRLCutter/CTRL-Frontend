package com.ctrlcutter.frontend.views.loginview.sublayouts;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LoginFormComponent extends VerticalLayout {

    public LoginFormComponent() {
        setId("loginFormComponent");
        
        H3 loginHeader = new H3("Login");
        
        /*TextField usernameField = new TextField();
        usernameField.setLabel("Username");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");*/
        
        LoginForm loginForm = new LoginForm();
        add(loginForm);
       
       add(loginHeader);
    }
    
}
