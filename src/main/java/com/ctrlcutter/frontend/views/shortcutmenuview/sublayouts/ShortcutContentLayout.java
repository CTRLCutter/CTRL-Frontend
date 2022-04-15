package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import java.util.List;
import java.util.Optional;

import com.ctrlcutter.frontend.entities.hotstring.Hotstring;
import com.ctrlcutter.frontend.entities.shortcut.Script;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.ctrlcutter.frontend.views.shortcutoverviewview.ShortcutOverviewView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.Tabs.SelectedChangeEvent;
import com.vaadin.flow.component.tabs.TabsVariant;

public class ShortcutContentLayout extends VerticalLayout {

    private Tab shortcutTab;
    private Tab hotstringTab;
    private VerticalLayout contentLayout;
    private List<Script> scripts;
    private List<Hotstring> hotstrings;

    public ShortcutContentLayout(List<Script> scripts, List<Hotstring> hotstrings) {
        setHeightFull();
        setId("contentLayout");
        this.scripts = scripts;
        this.hotstrings = hotstrings;

        H2 header = new H2(getTranslation("my_shortcuts_header"));
        add(header);

        this.contentLayout = generateShortcutLayout(scripts);

        this.shortcutTab = new Tab(getTranslation("shortcutmenu_shortcuts"));
        this.hotstringTab = new Tab(getTranslation("shortcutmenu_hotstrings"));

        Tabs tabs = new Tabs(shortcutTab, hotstringTab);
        tabs.setWidthFull();
        tabs.addThemeVariants(TabsVariant.LUMO_CENTERED);
        tabs.addSelectedChangeListener(this::setContent);

        add(tabs, this.contentLayout);
    }

    private void setContent(SelectedChangeEvent event) {
        Tab newTab = event.getSelectedTab();
        String tabLabel = newTab.getLabel();

        remove(this.contentLayout);
        this.contentLayout.removeAll();

        if (tabLabel.equals(this.shortcutTab.getLabel())) {
            this.contentLayout = generateShortcutLayout(this.scripts);
        } else if (tabLabel.equals(this.hotstringTab.getLabel())) {
            this.contentLayout = generateHotstringLayout(this.hotstrings);
        }

        add(this.contentLayout);
    }

    private VerticalLayout generateShortcutLayout(List<Script> scripts) {
        VerticalLayout shortcutLayout = new VerticalLayout();

        for (Script script : scripts) {
            for (Shortcut shortcut : script.getShortcuts()) {
                Div shortcutDiv = generateShortcutDiv(script, shortcut);
                shortcutLayout.add(shortcutDiv);
            }
        }

        return shortcutLayout;
    }

    private Div generateShortcutDiv(Script script, Shortcut shortcut) {
        Div shortcutDiv = new Div();
        shortcutDiv.setClassName("shortcutItem");
        shortcutDiv.setText(shortcut.getStringRepresentation());

        Button redirectionButton = new Button("Details");
        redirectionButton.addClickListener(e -> {
            String path = getOverviewPath(script.getScriptType(), script.getId(), shortcut.getId());
            UI.getCurrent().navigate(ShortcutOverviewView.class, path);
        });

        shortcutDiv.add(redirectionButton);

        return shortcutDiv;
    }

    private String getOverviewPath(String scriptType, Long scriptId, Optional<Long> shortcutId) {
        String path = scriptType + "/" + scriptId;

        if (scriptType.equals("predefined")) {
            path = scriptType + "/" + scriptId + "/" + shortcutId.get();
        }

        return path;
    }

    private VerticalLayout generateHotstringLayout(List<Hotstring> hotstrings) {
        VerticalLayout hotstringLayout = new VerticalLayout();

        for (Hotstring hotstring : hotstrings) {
            Div hotstringDiv = new Div();
            hotstringDiv.setClassName("shortcutItem");

            hotstringDiv.setText(hotstring.getStringRepresentation());

            Button redirectionButton = new Button("Details");
            redirectionButton.addClickListener(e -> {
                UI.getCurrent().navigate(ShortcutOverviewView.class, "basic/123");
            });

            hotstringDiv.add(redirectionButton);
            hotstringLayout.add(hotstringDiv);
        }

        return hotstringLayout;
    }
}
