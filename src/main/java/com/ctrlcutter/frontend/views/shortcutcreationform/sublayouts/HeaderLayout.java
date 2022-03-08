package com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HeaderLayout extends HorizontalLayout {

    public HeaderLayout(final String headerTitle) {

        setWidthFull();

        H1 header = new H1(headerTitle);
        header.setId("formHeader");

        add(header);
    }
}
