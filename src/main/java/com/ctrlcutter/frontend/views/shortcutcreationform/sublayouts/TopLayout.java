package com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts;

import com.ctrlcutter.frontend.util.constants.CTRLCutterConstants;
import com.ctrlcutter.frontend.util.ui.HorizontalDummyComponent;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class TopLayout extends HorizontalLayout {

    public TopLayout() {
        setWidthFull();

        Image logo = getCTRLCutterLogo();
        add(logo);

        HorizontalDummyComponent whiteSpaceComponent = new HorizontalDummyComponent("80%");

        // TODO ADD USER PROFILE ICON IN A SEPARATE LAYOUT 
        add(whiteSpaceComponent);
    }

    private Image getCTRLCutterLogo() {

        Image logo = new Image(CTRLCutterConstants.CTRLCUTTER_LOGO_FILEPATH_BLACK, "ctrlcutter logo");
        logo.setWidth("100px");
        logo.setHeight("100px");

        return logo;
    }
}
