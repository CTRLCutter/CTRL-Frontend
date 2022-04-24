package com.ctrlcutter.frontend.views.shortcuteditform.programform;

import com.ctrlcutter.frontend.dtos.BasicScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.ctrlcutter.frontend.util.mapper.ShortcutMapper;
import com.ctrlcutter.frontend.util.rest.ShortcutHelper;
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

@PageTitle("Program Shortcut Edit")
@Route(value = "program_shortcut_edit")
@CssImport("./themes/ctrlcutter/shortcutForm.css")
public class ProgramShortcutEditForm extends VerticalLayout implements HasUrlParameter<String> {

    private Long shortcutId;

    @Override
    public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {
        String[] parameterValues = parameter.split("/");

        this.shortcutId = Long.parseLong(parameterValues[0]);

        initOverview();
    }

    private void initOverview() {
        BasicScriptDTO scriptDTO = ShortcutHelper.getShortcutById(this.shortcutId);
        Shortcut shortcut = ShortcutMapper.mapScriptDTOToShortcut(scriptDTO);

        Hr horizontalLine = new Hr();
        horizontalLine.setId("dividerLine");

        HorizontalLayout topLayout = new TopLayout();

        HorizontalLayout headerLayout = new HeaderLayout("Program Shortcut");

        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setId("formLayout");
        formLayout.setWidthFull();

        ProgramShortcutEditFormComponent formComponent = new ProgramShortcutEditFormComponent(shortcut, String.valueOf(this.shortcutId));

        formLayout.add(formComponent);

        add(topLayout, horizontalLine, headerLayout, formLayout);

        setWidthFull();
        setHeightFull();
    }
}
