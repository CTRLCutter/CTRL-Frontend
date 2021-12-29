package com.ctrlcutter.frontend.views.shortcutmenuview;

import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.ContentLayout;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Shortcut Menu View")
@Route(value = "shortcutMenu")
@CssImport("./themes/ctrlcutter/shortcutMenu.css")
public class ShortcutMenuView extends HorizontalLayout {

    public ShortcutMenuView() {

        setId("menuView");

        add(new SidebarLayout(), new ContentLayout());
    }
}
