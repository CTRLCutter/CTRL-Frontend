package com.ctrlcutter.frontend.views.mainview.sublayouts;

import com.ctrlcutter.frontend.views.loginview.LoginView;
import com.ctrlcutter.frontend.views.registrationview.RegistrationView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ButtonLayout extends HorizontalLayout {

    public ButtonLayout() {

        setId("buttonLayout");

        Button loginButton = new Button(getTranslation("login_btn_text"));
        loginButton.setId("loginButton");

        loginButton.addClickListener(e -> {
            UI.getCurrent().navigate(LoginView.class);
        });

        Button signupButton = new Button(getTranslation("signup_btn_text"));
        signupButton.setId("basicSignupButton");

        signupButton.addClickListener(e -> {
            UI.getCurrent().navigate(RegistrationView.class);
        });

        add(loginButton, signupButton);
    }

}
