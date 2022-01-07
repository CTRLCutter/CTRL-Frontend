package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import com.ctrlcutter.frontend.util.CTRLCutterConstants;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class SidebarHeaderLayout extends HorizontalLayout {

    
    public SidebarHeaderLayout() {
             
        Image ctrlcutterIcon = new Image(CTRLCutterConstants.CTRLCUTTER_LOGO_FILEPATH_WHITE, "ctrlcutter icon");
        ctrlcutterIcon.setId("headerLogo");
        
        add(ctrlcutterIcon);
        setId("sidebarHeaderLayout");
    }
}
