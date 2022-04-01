package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import com.ctrlcutter.frontend.util.constants.CTRLCutterConstants;
import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.loginview.LoginView;
import com.ctrlcutter.frontend.views.mainview.MainView;
import com.ctrlcutter.frontend.views.userview.UserView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinSession;

public class SidebarHeaderLayout extends HorizontalLayout {

    public SidebarHeaderLayout() {

        Image ctrlcutterIcon = new Image(CTRLCutterConstants.CTRLCUTTER_LOGO_FILEPATH_WHITE, "ctrlcutter icon");
        ctrlcutterIcon.setId("headerLogo");

        Image userIcon = new Image(CTRLCutterConstants.USER_ICON_FILEPATH, "user icon");
        userIcon.setId("userIcon");

        Button ctrlcutterButton = new Button(ctrlcutterIcon);
        ctrlcutterButton.setId("ctrlcutterButton");
        ctrlcutterButton.addClickListener(e -> {
            ViewRedirectionUtility.redirectToView(MainView.class);
        });

        Button userButton = new Button(userIcon);
        userButton.setId("userButton");
        userButton.addClickListener(e -> {

            VaadinSession session = VaadinSession.getCurrent();
            Object sessionId = session.getAttribute("sessionKey");

            System.out.println(sessionId);

            Class<? extends Component> redirectionViewClass = LoginView.class;

            if (null != sessionId) {
                redirectionViewClass = UserView.class;
            }

            ViewRedirectionUtility.redirectToView(redirectionViewClass);
        });

        add(ctrlcutterButton, userButton);
        setId("sidebarHeaderLayout");
    }
}
