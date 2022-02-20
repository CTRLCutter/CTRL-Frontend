package com.ctrlcutter.frontend.views.shortcutselectionview;

import java.util.List;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Shortcut Selection")
@Route(value = "shortcut_selection")
@CssImport("./themes/ctrlcutter/shortcutSelectionView.css")
public class ShortcutSelectionView extends HorizontalLayout {

    public ShortcutSelectionView() {
        
        List<ShortcutSelectionTypes> shortcutTypes = ShortcutSelectionTypes.getAllTypes();
        
        
        for (ShortcutSelectionTypes shortcutType : shortcutTypes) {
            Div shortcutDiv = new Div();
            shortcutDiv.setClassName("shortcutType");

            shortcutDiv.setText(shortcutType.name());
            add(shortcutDiv);
        }
        
    }

}
