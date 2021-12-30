package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import java.util.List;

import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuSidebarOptions;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class SidebarLayout extends VerticalLayout {

    public SidebarLayout() {

        setId("sidebarLayout");

        HorizontalLayout sidebarHeaderLayout = new SidebarHeaderLayout();

        ListBox<ShortcutMenuSidebarOptions> listBox = new SidebarListBox();

        List<ShortcutMenuSidebarOptions> options = ShortcutMenuSidebarOptions.getAllOptions();

        listBox.setItems(options);

        add(sidebarHeaderLayout, listBox);
    }

}
