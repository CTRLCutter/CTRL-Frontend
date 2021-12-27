package com.ctrlcutter.frontend.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Shortcut Menu View")
@Route(value = "shortcutMenu")
@CssImport("./themes/ctrlcutter/shortcutMenu.css")
public class ShortcutMenuView extends HorizontalLayout {

    public ShortcutMenuView() {

        setId("menuView");
        
        VerticalLayout sidebarLayout = new VerticalLayout();
        sidebarLayout.setId("sidebarLayout");
        
        HorizontalLayout sidebarHeaderLayout = new HorizontalLayout();
        sidebarHeaderLayout.add(new H2("Test Header"));
        
        ListBox<String> listBox = new ListBox<>();
        listBox.setItems("Overview", "Shortcuts", "Create", "Settings");
        listBox.setValue("Overview");
        
        sidebarLayout.add(sidebarHeaderLayout);
        sidebarLayout.add(listBox);

        add(sidebarLayout);
        
        

    }

}
