package com.ctrlcutter.frontend.views.shortcutcreationform.predefinedform;

import com.ctrlcutter.frontend.views.shortcutcreationform.programform.ProgramShortcutFormComponent;
import com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts.HeaderLayout;
import com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts.TopLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Predefined Shortcut Creation")
@Route(value = "predefined_shortcut_creation")
@CssImport("./themes/ctrlcutter/shortcutForm.css")
public class PredefinedShortcutCreationForm extends VerticalLayout {

    public PredefinedShortcutCreationForm() {

        Hr horizontalLine = new Hr();
        horizontalLine.setId("dividerLine");

        HorizontalLayout topLayout = new TopLayout();

        HorizontalLayout headerLayout = new HeaderLayout("Predefined Shortcut");

        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setId("formLayout");
        formLayout.setWidthFull();

        PredefinedShortcutFormComponent formComponent = new PredefinedShortcutFormComponent();

        formLayout.add(formComponent);

        add(topLayout, horizontalLine, headerLayout, formLayout);

        setWidthFull();
        setHeightFull();
    }
}
