package com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class FormComponent extends VerticalLayout {

    public FormComponent() {
        setId("formComponent");

        //TODO ADD OTHER SHORTCUT SELECTOR

        TextArea shortcutTextField = new TextArea();
        shortcutTextField.setLabel("Text");
        shortcutTextField.setId("shortcutTextField");

        add(shortcutTextField);
    }

}
