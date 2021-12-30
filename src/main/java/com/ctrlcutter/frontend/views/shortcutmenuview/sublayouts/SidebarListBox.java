package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import java.util.HashMap;
import java.util.Map;

import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuSidebarOptions;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;

public class SidebarListBox extends ListBox<ShortcutMenuSidebarOptions> {

    private static Map<ShortcutMenuSidebarOptions, HorizontalLayout> rowLayouts = new HashMap<>();

    public SidebarListBox() {

        rowLayouts.values().forEach(layout -> layout.getElement().removeFromTree());      
        
        // TODO: It reloads now but it doesnt work if 2 or more panels are open... FIX!!! I really don't know why... :/
        setRenderer(new ComponentRenderer<>(option -> {

            HorizontalLayout rowLayout = null;

            if (rowLayouts.keySet().contains(option)) {
                rowLayout = rowLayouts.get(option);

            } else {
                rowLayout = getRowLayout(option);
                rowLayouts.put(option, rowLayout);
            }

            return rowLayout;
        }));
    }

    private HorizontalLayout getRowLayout(ShortcutMenuSidebarOptions option) {

        HorizontalLayout row = new HorizontalLayout();
        row.setAlignItems(FlexComponent.Alignment.CENTER);

        Span name = new Span(getTranslation(option.getTranslationKey()));

        VerticalLayout column = new VerticalLayout(name);
        column.setPadding(false);
        column.setSpacing(false);

        row.add(option.getOptionIcon(), column);

        row.getStyle().set("line-height", "var(--lumo-line-height-m)");

        row.getElement().removeFromTree();

        return row;
    }
}
