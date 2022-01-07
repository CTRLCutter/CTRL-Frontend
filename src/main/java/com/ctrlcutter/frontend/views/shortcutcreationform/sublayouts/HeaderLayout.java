package com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HeaderLayout extends HorizontalLayout {

    public HeaderLayout() {
        setWidthFull();

        H1 header = new H1("Text Shortcut");
        header.setId("formHeader");

        add(header);
    }
}
