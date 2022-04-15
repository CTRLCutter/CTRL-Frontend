package com.ctrlcutter.frontend.views.shortcutmenuview;

import java.util.List;

import com.ctrlcutter.frontend.entities.hotstring.Hotstring;
import com.ctrlcutter.frontend.entities.hotstring.IHotstringProvider;
import com.ctrlcutter.frontend.entities.shortcut.IShortcutProvider;
import com.ctrlcutter.frontend.entities.shortcut.Script;
import com.ctrlcutter.frontend.util.provider.HotstringProvider;
import com.ctrlcutter.frontend.util.provider.ShortcutProvider;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.EmptyShortcutContentLayout;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.ShortcutContentLayout;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.Component;
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

        SidebarLayout sidebarLayout = new SidebarLayout(ShortcutMenuSidebarOptions.SHORTCUTS);

        add(sidebarLayout);

        IShortcutProvider shortcutProvider = new ShortcutProvider();
        List<Script> existingScripts = shortcutProvider.provideUserScripts();

        IHotstringProvider hotstringProvider = new HotstringProvider();
        List<Hotstring> existingHotstrings = hotstringProvider.provideUserHotstrings();

        Component shortcutContentLayout = new EmptyShortcutContentLayout();

        if (existingScripts.size() > 0 || existingHotstrings.size() > 0) {
            shortcutContentLayout = new ShortcutContentLayout(existingScripts, existingHotstrings);
        }

        add(shortcutContentLayout);
    }
}
