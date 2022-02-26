package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import com.ctrlcutter.frontend.util.constants.CTRLCutterConstants;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class EmptyShortcutContentLayout extends VerticalLayout {

    public EmptyShortcutContentLayout() {
        
        setId("shortcutContentLayout");

        Image keyboardImage = new Image(CTRLCutterConstants.KEYBOARD_ICON_FILEPATH, "keyboard icon");
        keyboardImage.setWidth("320px");
        keyboardImage.setId("shortcutKeyboardImage");
        
        add(keyboardImage, new TextContentLayout());
    }

}
