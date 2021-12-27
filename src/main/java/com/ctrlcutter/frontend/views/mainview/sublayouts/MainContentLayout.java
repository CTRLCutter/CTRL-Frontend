package com.ctrlcutter.frontend.views.mainview.sublayouts;

import com.ctrlcutter.frontend.views.ShortcutMenuView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MainContentLayout extends VerticalLayout {

    public MainContentLayout() {

        H2 titleText = new H2("Take Control of your Macros");
        titleText.setId("titleText");

        Paragraph infoText1 = new Paragraph("Create your own custom macros for everything.");
        Paragraph infoText2 = new Paragraph("No coding. No hassle.");
        Paragraph infoText3 = new Paragraph("Everything at your hands.");

        Button greenSignupButton = generateGreenSignupButton();

        Paragraph tryWithoutLink = generateTryWithoutLink();

        add(titleText, infoText1, infoText2, infoText3, greenSignupButton, tryWithoutLink);

        setWidth("70%");
        setId("mainContentLayout");
    }

    private Button generateGreenSignupButton() {

        Button greenSignupButton = new Button("Sign up for free");
        greenSignupButton.addClickListener(e -> {
            Notification.show("Another signup stub");
        });

        greenSignupButton.setClassName("signupButton");

        return greenSignupButton;
    }

    private Paragraph generateTryWithoutLink() {

        Paragraph tryWithoutLink = new Paragraph("Try without account");
        tryWithoutLink.setId("tryWithoutLink");

        tryWithoutLink.addClickListener(e -> {
            UI.getCurrent().navigate(ShortcutMenuView.class);
        });

        return tryWithoutLink;
    }

}
