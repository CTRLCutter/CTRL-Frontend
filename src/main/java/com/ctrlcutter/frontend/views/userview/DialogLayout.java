package com.ctrlcutter.frontend.views.userview;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DialogLayout extends VerticalLayout {

    public DialogLayout(Component... children) {
        setPadding(false);
        setSpacing(false);
        setAlignItems(FlexComponent.Alignment.STRETCH);
        getStyle().set("width", "18rem").set("max-width", "100%");
        add(children);
    }
}
