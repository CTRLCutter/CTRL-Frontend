package com.ctrlcutter.frontend.views.shortcutmenuview;

import com.ctrlcutter.frontend.util.CTRLCutterConstants;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Shortcut Menu View")
@Route(value = "shortcutMenu")
@CssImport("./themes/ctrlcutter/shortcutMenu.css")
public class ShortcutMenuView extends HorizontalLayout {

    public ShortcutMenuView() {

        setId("menuView");

        VerticalLayout sidebarLayout = new VerticalLayout();
        sidebarLayout.setId("sidebarLayout");

        HorizontalLayout sidebarHeaderLayout = new HorizontalLayout();
        sidebarHeaderLayout.add(new H2("Test Header"));

        sidebarHeaderLayout.setId("sidebarHeaderLayout");

        ListBox<String> listBox = new ListBox<>();
        listBox.setItems("Overview", "Shortcuts", "Create", "Settings");
        listBox.setValue("Overview");

        sidebarLayout.add(sidebarHeaderLayout);
        sidebarLayout.add(listBox);

        VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.setId("shortcutContentLayout");

        Image keyboardImage = new Image(CTRLCutterConstants.KEYBOARD_ICON_FILEPATH, "keyboard icon");
        keyboardImage.setWidth("320px");
        keyboardImage.setId("shortcutKeyboardImage");
        contentLayout.add(keyboardImage);

        VerticalLayout textContentLayout = new VerticalLayout();
        textContentLayout.setId("textContentLayout");
        H1 header = new H1("Create a Shortcut");

        Paragraph subtitleText = new Paragraph();
        subtitleText.getElement().setProperty("innerHTML", "Enhance your productivity<br>by creating a new shortcut.");

        Button createShortcutButton = new Button("Create Shortcut");
        createShortcutButton.setId("createShortcutButton");

        textContentLayout.add(header, subtitleText, createShortcutButton);
        contentLayout.add(textContentLayout);

        add(sidebarLayout);
        add(contentLayout);
    }
}
