package com.ctrlcutter.frontend.views.shortcutoverviewview;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ctrlcutter.frontend.dtos.BasicScriptDTO;
import com.ctrlcutter.frontend.dtos.PredefinedScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.ctrlcutter.frontend.util.mapper.ShortcutMapper;
import com.ctrlcutter.frontend.util.rest.ShortcutHelper;
import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuSidebarOptions;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.WildcardParameter;

@PageTitle("Shortcut Overview")
@Route(value = "shortcutOverview")
@CssImport("./themes/ctrlcutter/shortcutOverview.css")
public class ShortcutOverviewView extends HorizontalLayout implements HasUrlParameter<String> {

    private Long shortcutId;
    private Optional<Long> defaultScriptId;
    private String type;

    @Override
    public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {
        String[] parameterValues = parameter.split("/");

        this.type = parameterValues[0];
        this.shortcutId = Long.parseLong(parameterValues[1]);
        this.defaultScriptId = Optional.empty();

        if (parameterValues.length > 2) {
            this.defaultScriptId = Optional.of(Long.parseLong(parameterValues[2]));
        }

        initOverview();
    }

    private void initOverview() {
        setId("shortcutOverview");

        SidebarLayout sidebarLayout = new SidebarLayout(ShortcutMenuSidebarOptions.SHORTCUTS);
        add(sidebarLayout);

        IOverviewShortcut overviewShortcut = null;

        if (this.type.equals("basic")) {
            BasicScriptDTO scriptDTO = ShortcutHelper.getShortcutById(this.shortcutId);
            Shortcut shortcut = ShortcutMapper.mapScriptDTOToShortcut(scriptDTO);
            OverviewShortcutType shortcutType = OverviewShortcutType.getShortcutTypeByCommand(scriptDTO.getCommand());
            overviewShortcut = new OverviewShortcut(shortcut, shortcutType, scriptDTO.getParameters().get(0));
        }

        if (this.type.equals("predefined")) {
            PredefinedScriptDTO scriptDTO = ShortcutHelper.getPredefinedShortcutById(this.shortcutId);
            List<Shortcut> shortcuts = scriptDTO.getShortcuts().stream().map(ShortcutMapper::mapDefaultScriptDTOToShortcut).collect(Collectors.toList());
            Shortcut shortcut = ShortcutHelper.getShortcutById(shortcuts, this.defaultScriptId.get());
            overviewShortcut = new PredefinedOverviewShortcut(shortcut, this.type, scriptDTO.getScriptType());
        }

        VerticalLayout contentLayout = generateContentLayout(overviewShortcut);
        HorizontalLayout buttonLayout = generateButtonLayout();

        contentLayout.add(buttonLayout);
        add(contentLayout);
    }

    private VerticalLayout generateContentLayout(IOverviewShortcut overviewShortcut) {
        VerticalLayout contentLayout = new VerticalLayout();

        H2 title = new H2(getTranslation("overview_title"));
        title.setWidthFull();
        title.addClassName("centeredText");

        Label shortcutTypeLabel = new Label(overviewShortcut.getShortcutType());
        Label shortcutActionLabel = new Label(overviewShortcut.getShortcutAction());
        Label shortcutKeysLabel = new Label(overviewShortcut.getShortcut().getStringRepresentation());

        contentLayout.add(title, shortcutTypeLabel, shortcutActionLabel, shortcutKeysLabel);

        return contentLayout;
    }

    private HorizontalLayout generateButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setWidthFull();

        Button editButton = generateEditButton();
        Button deleteButton = generateDeleteButton();

        buttonLayout.add(editButton, deleteButton);

        return buttonLayout;
    }

    private Button generateEditButton() {
        Button editButton = new Button(getTranslation("overview_edit_button_title"));
        editButton.addClassName("overviewButton");
        editButton.addClickListener(e -> {
            Notification.show("Edit button stub.");
        });

        return editButton;
    }

    private Button generateDeleteButton() {
        Button deleteButton = new Button(getTranslation("overview_delete_button_title"));
        deleteButton.addClassName("overviewButton");
        deleteButton.setId("deleteButton");
        deleteButton.addClickListener(e -> {
            Notification.show("Delete button stub.");
        });

        return deleteButton;
    }
}
