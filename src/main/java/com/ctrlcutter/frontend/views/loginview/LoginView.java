package com.ctrlcutter.frontend.views.loginview;

import com.ctrlcutter.frontend.dtos.LoginUserDTO;
import com.ctrlcutter.frontend.dtos.SessionDTO;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

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
        loginForm.addLoginListener(this::loginUser);

        add(loginForm);
    }

    private void loginUser(LoginEvent event) {
        LoginUserDTO user = new LoginUserDTO(event.getUsername(), event.getPassword());
        
        SessionDTO sessionDTO = RestRequestHelper.loginUser(user);

        VaadinSession session = VaadinSession.getCurrent();
        session.setAttribute("sessionKey", sessionDTO.getSessionKey());
        VaadinSession.setCurrent(session);
        
        ViewRedirectionUtility.redirectToView(ShortcutMenuView.class);
    }
}
