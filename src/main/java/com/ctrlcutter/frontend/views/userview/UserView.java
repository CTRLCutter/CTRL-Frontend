package com.ctrlcutter.frontend.views.userview;

import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("UserInfo")
@Route(value = "userInfo")
@CssImport("./themes/ctrlcutter/userInfo.css")
public class UserView extends HorizontalLayout {

    public UserView() {

        setId("userView");

        SidebarLayout sidebarLayout = new SidebarLayout();

        VerticalLayout userInfoLayout = new VerticalLayout();
        H2 headerText = new H2("TestUser");
        headerText.addClassName("centeredText");
        headerText.setWidthFull();
        
        Paragraph userInfo = new Paragraph("This is just a text stub for some user info and yeah... I just want to will this section with text.");

        userInfoLayout.add(headerText, userInfo);

        add(sidebarLayout, userInfoLayout);
    }
}
