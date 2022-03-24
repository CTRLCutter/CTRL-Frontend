package com.ctrlcutter.frontend.views.shortcutoverviewview;

import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuSidebarOptions;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.WildcardParameter;

@PageTitle("Shortcut Overview")
@Route(value = "shortcutOverview")
@CssImport("./themes/ctrlcutter/shortcutOverview.css")
public class ShortcutOverviewView extends HorizontalLayout implements HasUrlParameter<String> {

    private String shortcutId;

    @Override
    public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {

        this.shortcutId = parameter;
        initOverview();
    }

    private void initOverview() {

        setId("shortcutOverview");

        SidebarLayout sidebarLayout = new SidebarLayout(ShortcutMenuSidebarOptions.SHORTCUTS);
        add(sidebarLayout);

        IOverviewShortcut shortcut = new MockShortcut();

        VerticalLayout contentLayout = new VerticalLayout();

        H2 title = new H2("Shortcut Overview");
        title.setWidthFull();
        title.addClassName("centeredText");
        
        Label shortcutTypeLabel = new Label(shortcut.getShortcutType());
        Label shortcutActionLabel = new Label(shortcut.getShortcutAction());
        Label shortcutKeysLabel = new Label(shortcut.getShortcut().getStringRepresentation());

        contentLayout.add(title, shortcutTypeLabel, shortcutActionLabel, shortcutKeysLabel);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setWidthFull();

        Button editButton = new Button("Edit");
        editButton.addClassName("overviewButton");
        editButton.addClickListener(e -> {
            Notification.show("Edit button stub.");
        });

        Button deleteButton = new Button("Delete");
        deleteButton.addClassName("overviewButton");
        deleteButton.setId("deleteButton");
        deleteButton.addClickListener(e -> {
            Notification.show("Delete button stub.");
        });

        buttonLayout.add(editButton, deleteButton);

        contentLayout.add(buttonLayout);

        add(contentLayout);
    }
}
