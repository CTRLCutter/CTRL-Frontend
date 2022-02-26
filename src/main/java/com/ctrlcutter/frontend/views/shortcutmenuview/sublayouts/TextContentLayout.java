package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.shortcutselectionview.ShortcutSelectionView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TextContentLayout extends VerticalLayout {

    public TextContentLayout() {

        setId("textContentLayout");
        H1 header = new H1(getTranslation("shortcut_content_header"));

        Paragraph subtitleText = new Paragraph();
        subtitleText.getElement().setProperty("innerHTML", getTranslation("subtitle_text"));

        Button createShortcutButton = new Button(getTranslation("create_shortcut_button"));
        createShortcutButton.setId("createShortcutButton");

        createShortcutButton.addClickListener(e -> {
            ViewRedirectionUtility.redirectToView(ShortcutSelectionView.class);
        });

        add(header, subtitleText, createShortcutButton);
    }
}
