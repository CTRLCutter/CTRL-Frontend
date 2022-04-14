package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import java.util.List;

import com.ctrlcutter.frontend.entities.hotstring.Hotstring;
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
    private List<Shortcut> shortcuts;
    private List<Hotstring> hotstrings;

    public ShortcutContentLayout(List<Shortcut> shortcuts, List<Hotstring> hotstrings) {

        setHeightFull();
        setId("contentLayout");
        this.shortcuts = shortcuts;
        this.hotstrings = hotstrings;

        H2 header = new H2(getTranslation("my_shortcuts_header"));
        add(header);

        this.contentLayout = generateShortcutLayout(shortcuts);

        this.shortcutTab = new Tab("Shortcuts");
        this.hotstringTab = new Tab("Hotstrings");

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
            this.contentLayout = generateShortcutLayout(this.shortcuts);
        } else if (tabLabel.equals(this.hotstringTab.getLabel())) {
            this.contentLayout = generateHotstringLayout(this.hotstrings);
        }
        
        add(this.contentLayout);
    }

    private VerticalLayout generateShortcutLayout(List<Shortcut> shortcuts) {
        VerticalLayout shortcutLayout = new VerticalLayout();

        for (Shortcut shortcut : shortcuts) {
            Div shortcutDiv = new Div();
            shortcutDiv.setClassName("shortcutItem");

            shortcutDiv.setText(shortcut.getStringRepresentation());

            Button redirectionButton = new Button("Details");
            redirectionButton.addClickListener(e -> {
                UI.getCurrent().navigate(ShortcutOverviewView.class, "testId");
            });

            shortcutDiv.add(redirectionButton);
            shortcutLayout.add(shortcutDiv);
        }

        return shortcutLayout;
    }

    private VerticalLayout generateHotstringLayout(List<Hotstring> hotstrings) {
        VerticalLayout hotstringLayout = new VerticalLayout();

        for (Hotstring hotstring : hotstrings) {

            Div hotstringDiv = new Div();
            hotstringDiv.setClassName("shortcutItem");

            hotstringDiv.setText(hotstring.getStringRepresentation());

            Button redirectionButton = new Button("Details");
            redirectionButton.addClickListener(e -> {
                UI.getCurrent().navigate(ShortcutOverviewView.class, "testId");
            });

            hotstringDiv.add(redirectionButton);
            hotstringLayout.add(hotstringDiv);
        }

        return hotstringLayout;
    }
}
