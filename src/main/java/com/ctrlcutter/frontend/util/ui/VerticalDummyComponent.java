package com.ctrlcutter.frontend.util.ui;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class VerticalDummyComponent extends HorizontalLayout {

    public VerticalDummyComponent(String height) {
        setHeight(height);
        setWidthFull();
    }

}
