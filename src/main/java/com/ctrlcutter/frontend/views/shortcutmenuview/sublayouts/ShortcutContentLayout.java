package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import java.util.List;

import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.ctrlcutter.frontend.views.shortcutoverviewview.ShortcutOverviewView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ShortcutContentLayout extends VerticalLayout {

    public ShortcutContentLayout(List<Shortcut> shortcuts) {

        setHeightFull();
        setId("contentLayout");

        H2 header = new H2(getTranslation("my_shortcuts_header"));
        add(header);

        for (Shortcut shortcut : shortcuts) {

            Div shortcutDiv = new Div();
            shortcutDiv.setClassName("shortcutItem");

            shortcutDiv.setText(shortcut.getStringRepresentation());

            Button redirectionButton = new Button("Details");
            redirectionButton.addClickListener(e -> {
                UI.getCurrent().navigate(ShortcutOverviewView.class, "testId");
            });
            
            shortcutDiv.add(redirectionButton);

            add(shortcutDiv);
        }
    }
}
