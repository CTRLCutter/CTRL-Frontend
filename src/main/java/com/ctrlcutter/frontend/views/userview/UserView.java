package com.ctrlcutter.frontend.views.userview;

import com.ctrlcutter.frontend.dtos.SessionUserDTO;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.mainview.MainView;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@PageTitle("UserInfo")
@Route(value = "userInfo")
@CssImport("./themes/ctrlcutter/userInfo.css")
public class UserView extends HorizontalLayout {

    public UserView() {

        setId("userView");

        VaadinSession session = VaadinSession.getCurrent();
        Object sessionKey = session.getAttribute("sessionKey");

        // Session ID at this point cannot be null since the check already happed at the initialisation of the redirection button.
        SessionUserDTO sessionUser = RestRequestHelper.retrieveUserInformation((String) sessionKey);

        SidebarLayout sidebarLayout = new SidebarLayout();

        VerticalLayout userInfoLayout = new VerticalLayout();
        H2 headerText = new H2("Welcome " + sessionUser.getUsername());
        headerText.addClassName("centeredText");
        headerText.setWidthFull();

        Paragraph userInfo = new Paragraph("This is just a text stub for some user info and yeah... I just want to will this section with text.");

        Button logoutButton = new Button("Logout");
        logoutButton.addClickListener(e -> {
            session.setAttribute("sessionKey", null);
            VaadinSession.setCurrent(session);
            ViewRedirectionUtility.redirectToView(MainView.class);
        });

        userInfoLayout.add(headerText, userInfo, logoutButton);

        add(sidebarLayout, userInfoLayout);
    }
}
