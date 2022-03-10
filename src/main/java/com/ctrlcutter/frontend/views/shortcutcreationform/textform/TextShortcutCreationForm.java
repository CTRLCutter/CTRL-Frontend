package com.ctrlcutter.frontend.views.shortcutcreationform.textform;

import com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts.HeaderLayout;
import com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts.TopLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Text Shortcut Creation")
@Route(value = "text_shortcut_creation")
@CssImport("./themes/ctrlcutter/shortcutForm.css")
public class TextShortcutCreationForm extends VerticalLayout {

    public TextShortcutCreationForm() {

        Hr horizontalLine = new Hr();
        horizontalLine.setId("dividerLine");

        HorizontalLayout topLayout = new TopLayout();

        HorizontalLayout headerLayout = new HeaderLayout("Text Shortcut");

        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setId("formLayout");
        formLayout.setWidthFull();

        TextShortcutFormComponent formComponent = new TextShortcutFormComponent();

        formLayout.add(formComponent);

        add(topLayout, horizontalLine, headerLayout, formLayout);

        setWidthFull();
        setHeightFull();
    }

}
