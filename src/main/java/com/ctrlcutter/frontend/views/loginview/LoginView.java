package com.ctrlcutter.frontend.views.loginview;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.LoginForm;
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
        loginForm.setId("loginForm");
        
        add(loginForm);
    }

}
