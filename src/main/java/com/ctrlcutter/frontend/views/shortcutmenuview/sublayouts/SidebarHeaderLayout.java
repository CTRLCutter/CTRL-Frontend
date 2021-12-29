package com.ctrlcutter.frontend.views.shortcutmenuview.sublayouts;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class SidebarHeaderLayout extends HorizontalLayout {

    
    public SidebarHeaderLayout() {
        
        // TODO Fill with the header Content.
        
        add(new H2("Test Header"));
        setId("sidebarHeaderLayout");
    }
}
