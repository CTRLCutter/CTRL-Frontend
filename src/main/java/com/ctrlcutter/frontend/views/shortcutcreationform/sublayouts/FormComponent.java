package com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts;

import com.ctrlcutter.frontend.views.shortcutcreationform.components.ShortcutSelector;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class FormComponent extends VerticalLayout {

    public FormComponent() {
        setId("formComponent");

        ShortcutSelector selector = new ShortcutSelector();
        selector.setId("shortcutSelector");

        TextArea shortcutTextField = new TextArea();
        shortcutTextField.setLabel("Text");
        shortcutTextField.setId("shortcutTextField");

        add(shortcutTextField, selector);
    }

}
