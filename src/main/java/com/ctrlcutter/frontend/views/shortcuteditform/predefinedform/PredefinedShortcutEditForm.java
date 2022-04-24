package com.ctrlcutter.frontend.views.shortcuteditform.predefinedform;

import java.util.Optional;

import com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts.HeaderLayout;
import com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts.TopLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.WildcardParameter;

@PageTitle("Predefined Shortcut Edit")
@Route(value = "predefined_shortcut_edit")
@CssImport("./themes/ctrlcutter/shortcutForm.css")
public class PredefinedShortcutEditForm extends VerticalLayout implements HasUrlParameter<String> {

    private Long shortcutId;
    private Optional<Long> defaultScriptId;
    private String type;

    @Override
    public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {
        String[] parameterValues = parameter.split("/");

        // TODO... THIS NEEDS REWORK WHEN PREDEFINED ARE WORKABLE...
        this.type = parameterValues[0];
        this.shortcutId = Long.parseLong(parameterValues[1]);
        this.defaultScriptId = Optional.empty();

        if (parameterValues.length > 2) {
            this.defaultScriptId = Optional.of(Long.parseLong(parameterValues[2]));
        }

        initOverview();
    }

    private void initOverview() {
        Hr horizontalLine = new Hr();
        horizontalLine.setId("dividerLine");

        HorizontalLayout topLayout = new TopLayout();

        HorizontalLayout headerLayout = new HeaderLayout("Predefined Shortcut");

        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setId("formLayout");
        formLayout.setWidthFull();

        PredefinedShortcutEditFormComponent formComponent = new PredefinedShortcutEditFormComponent();

        formLayout.add(formComponent);

        add(topLayout, horizontalLine, headerLayout, formLayout);

        setWidthFull();
        setHeightFull();
    }
}
