package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import java.util.List;

import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuSidebarOptions;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;

public class SidebarLayout extends VerticalLayout {

    public SidebarLayout() {

        setId("sidebarLayout");

        HorizontalLayout sidebarHeaderLayout = new SidebarHeaderLayout();

        ListBox<ShortcutMenuSidebarOptions> listBox = new ListBox<>();

        List<ShortcutMenuSidebarOptions> options = ShortcutMenuSidebarOptions.getAllOptions();

        listBox.setItems(options);

        listBox.setRenderer(new ComponentRenderer<>(option -> {
            HorizontalLayout row = new HorizontalLayout();
            row.setAlignItems(FlexComponent.Alignment.CENTER);

            Span name = new Span(getTranslation(option.getTranslationKey()));

            VerticalLayout column = new VerticalLayout(name);
            column.setPadding(false);
            column.setSpacing(false);

            row.add(option.getOptionIcon(), column);
            row.getStyle().set("line-height", "var(--lumo-line-height-m)");
            return row;
        }));

        add(sidebarHeaderLayout, listBox);
    }

}
