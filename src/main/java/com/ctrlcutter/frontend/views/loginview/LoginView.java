package com.ctrlcutter.frontend.views.loginview;

import com.ctrlcutter.frontend.dtos.LoginUserDTO;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Login")
@Route(value = "login")
@CssImport("./themes/ctrlcutter/loginView.css")
public class LoginView extends HorizontalLayout {

    public LoginView() {
        setId("loginView");
        setHeightFull();

        LoginForm loginForm = new LoginForm();
        loginForm.setForgotPasswordButtonVisible(false);
        loginForm.setId("loginForm");
        loginForm.addLoginListener(e -> {
            LoginUserDTO user = new LoginUserDTO(e.getUsername(), e.getPassword());
            loginUser(user);
        });

        add(loginForm);
    }

    private void loginUser(LoginUserDTO user) {
        Notification.show(user.getEmail() + " Login");
    }
}
