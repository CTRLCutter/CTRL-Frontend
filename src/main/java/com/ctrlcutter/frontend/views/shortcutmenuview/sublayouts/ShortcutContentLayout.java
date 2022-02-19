package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import java.util.List;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ShortcutContentLayout extends VerticalLayout {

    public ShortcutContentLayout(List<Shortcut> shortcuts) {

        setHeightFull();
        setId("contentLayout");

        for (Shortcut shortcut : shortcuts) {
            Div shortcutDiv = new Div();
            shortcutDiv.setClassName("shortcutItem");

            shortcutDiv.setText(shortcut.getStringRepresentation());
            add(shortcutDiv);
        }
    }

}
