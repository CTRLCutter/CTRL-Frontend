package com.ctrlcutter.frontend.views.shortcutselectionview;

import java.util.List;

import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuSidebarOptions;
import com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts.SidebarLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Shortcut Selection")
@Route(value = "shortcut_selection")
@CssImport("./themes/ctrlcutter/shortcutSelectionView.css")
public class ShortcutSelectionView extends HorizontalLayout {

    public ShortcutSelectionView() {

        setId("selectionView");

        SidebarLayout sidebarLayout = new SidebarLayout(ShortcutMenuSidebarOptions.CREATE);
        VerticalLayout selectionView = new VerticalLayout();

        List<ShortcutSelectionTypes> shortcutTypes = ShortcutSelectionTypes.getAllTypes();
        HorizontalLayout itemLayout = new HorizontalLayout();
        itemLayout.setId("itemLayout");

        H1 selectionViewHeader = new H1(getTranslation("shortcut_selection_header"));
        selectionViewHeader.setId("selectionViewHeader");
        selectionViewHeader.setWidthFull();

        for (ShortcutSelectionTypes shortcutType : shortcutTypes) {

            Div shortcutDiv = new Div();
            shortcutDiv.setClassName("shortcutType");
            Label l = new Label(shortcutType.name());
            l.setClassName("shortcutLabel");
            shortcutDiv.add(l);

            shortcutDiv.addClickListener(e -> {
                ViewRedirectionUtility.redirectToView(shortcutType.getShortcutFormView());
            });

            itemLayout.add(shortcutDiv);
        }

        selectionView.add(selectionViewHeader, itemLayout);

        add(sidebarLayout, selectionView);
    }

}
