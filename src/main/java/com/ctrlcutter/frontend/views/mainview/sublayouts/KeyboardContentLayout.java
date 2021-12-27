package com.ctrlcutter.frontend.views.mainview.sublayouts;

import com.ctrlcutter.frontend.util.CTRLCutterConstants;
import com.ctrlcutter.frontend.util.VerticalDummyComponent;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class KeyboardContentLayout extends VerticalLayout {

    public KeyboardContentLayout() {

        VerticalDummyComponent dummyComponent = new VerticalDummyComponent("40%");

        add(dummyComponent);

        Image keyboardImage = new Image(CTRLCutterConstants.KEYBOARD_ICON_FILEPATH, "keyboard icon");
        keyboardImage.setId("keyboardIcon");
        keyboardImage.setWidth("320px");
        add(keyboardImage);
        setId("keyboardContentLayout");

        Span circle = new Span();
        circle.setId("circle");
        add(circle);

        setWidth("30%");
    }

}
