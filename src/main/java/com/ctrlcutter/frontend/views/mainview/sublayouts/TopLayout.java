package com.ctrlcutter.frontend.views.mainview.sublayouts;

import com.ctrlcutter.frontend.util.CTRLCutterConstants;
import com.ctrlcutter.frontend.util.HorizontalDummyComponent;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class TopLayout extends HorizontalLayout {

    
    public TopLayout() {
        
        setId("topLayout");

        Image logo = getCTRLCutterLogo();
        add(logo);

        HorizontalLayout buttonLayout = new ButtonLayout();

        HorizontalDummyComponent whiteSpaceComponent = new HorizontalDummyComponent("80%");

        add(whiteSpaceComponent, buttonLayout);

        setWidthFull();

    }
    
    private Image getCTRLCutterLogo() {

        Image logo = new Image(CTRLCutterConstants.CTRLCUTTER_LOGO_FILEPATH, "ctrlcutter logo");
        logo.setWidth("100px");
        logo.setHeight("100px");

        return logo;
    }
    
}
