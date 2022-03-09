package com.ctrlcutter.frontend.views.settingsview;

import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuSidebarOptions;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Settings")
@Route(value = "settings")
@CssImport("./themes/ctrlcutter/settingsView.css")
public class SettingsView extends HorizontalLayout {

    public SettingsView() {

        setId("settingsView");

        SidebarLayout sidebarLayout = new SidebarLayout(ShortcutMenuSidebarOptions.SETTINGS);
        VerticalLayout settingsLayout = new VerticalLayout();

        H1 settingsHeader = new H1(getTranslation("settings_header"));
        settingsHeader.setId("settingsHeader");
        
        Paragraph settingsContentParagraph = new Paragraph("This is just a little test content thing as a placeholder for later settings content.");

        settingsLayout.add(settingsHeader, settingsContentParagraph);

        add(sidebarLayout, settingsLayout);
    }

}
