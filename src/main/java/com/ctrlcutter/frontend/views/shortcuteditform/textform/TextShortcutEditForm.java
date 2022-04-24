package com.ctrlcutter.frontend.views.shortcuteditform.textform;

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

@PageTitle("Text Shortcut Edit")
@Route(value = "text_shortcut_edit")
@CssImport("./themes/ctrlcutter/shortcutForm.css")
public class TextShortcutEditForm extends VerticalLayout implements HasUrlParameter<String> {

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

        HorizontalLayout headerLayout = new HeaderLayout("Text Shortcut");

        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setId("formLayout");
        formLayout.setWidthFull();

        TextShortcutEditFormComponent formComponent = new TextShortcutEditFormComponent(shortcut, scriptDTO.getParameters().get(0), String.valueOf(this.shortcutId));

        formLayout.add(formComponent);

        add(topLayout, horizontalLine, headerLayout, formLayout);

        setWidthFull();
        setHeightFull();
    }
}
