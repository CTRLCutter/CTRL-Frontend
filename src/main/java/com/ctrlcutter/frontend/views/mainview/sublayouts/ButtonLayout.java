package com.ctrlcutter.frontend.views.mainview.sublayouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ButtonLayout extends HorizontalLayout {

    public ButtonLayout() {

        setId("buttonLayout");

        Button loginButton = new Button("Log In");
        loginButton.setId("loginButton");

        Button signupButton = new Button("Sign Up");
        signupButton.setId("basicSignupButton");

        loginButton.addClickListener(e -> {
            Notification.show("Login Stub");
        });

        signupButton.addClickListener(e -> {
            Notification.show("Signup Stub");
        });

        add(loginButton, signupButton);
    }

}
