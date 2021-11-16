package com.ctrlcutter.frontend.views;

import com.ctrlcutter.frontend.util.DummyComponent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Main View")
@Route(value = "main", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {

    public MainView() {
        setMargin(true);

        HorizontalLayout topLayout = new HorizontalLayout();

        Image logo = new Image("images/ctrlcutter_logo_black_white.png", "placeholder plant");
        logo.setWidth("100px");
        logo.setHeight("100px");
        topLayout.add(logo);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        DummyComponent whiteSpaceComponent = new DummyComponent("80%");

        Button loginButton = new Button("Log In");
        Button signupButton = new Button("Sign Up");

        loginButton.addClickListener(e -> {
            Notification.show("Login Stub");
        });

        signupButton.addClickListener(e -> {
            Notification.show("Signup Stub");
        });

        buttonLayout.add(loginButton, signupButton);
        topLayout.add(whiteSpaceComponent, buttonLayout);

        topLayout.setWidthFull();

        add(topLayout);

        VerticalLayout mainContentLayout = new VerticalLayout();

        H2 titleText = new H2("Take Control of your Macros");

        Paragraph infoText1 = new Paragraph("Create your own custom macros for everything.");
        Paragraph infoText2 = new Paragraph("No coding. No hassle.");
        Paragraph infoText3 = new Paragraph("Everything at your hands.");

        Button greenSignupButton = new Button("Sign up for free");
        greenSignupButton.addClickListener(e -> {
            Notification.show("Another signup stub");
        });

        Paragraph tryWithoutLink = new Paragraph("Try without account");
        tryWithoutLink.addClickListener(e -> {
            Notification.show("Try Without Stub");
        });

        mainContentLayout.add(titleText, infoText1, infoText2, infoText3, greenSignupButton, tryWithoutLink);

        mainContentLayout.setWidthFull();

        add(mainContentLayout);

        setWidthFull();
        setHeightFull();

    }
}
