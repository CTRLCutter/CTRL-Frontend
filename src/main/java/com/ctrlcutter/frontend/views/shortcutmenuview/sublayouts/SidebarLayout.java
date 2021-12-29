package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import java.util.List;
import java.util.stream.Collectors;

import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuSidebarOptions;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class SidebarLayout extends VerticalLayout{

    
    public SidebarLayout() {
        
        setId("sidebarLayout");

        HorizontalLayout sidebarHeaderLayout = new SidebarHeaderLayout();

        ListBox<String> listBox = new ListBox<>();

        List<ShortcutMenuSidebarOptions> options = ShortcutMenuSidebarOptions.getAllOptions();

        listBox.setItems(options.stream().map(option -> getTranslation(option.getTranslationKey())).collect(Collectors.toList()));

        add(sidebarHeaderLayout, listBox);
    }
    
}
