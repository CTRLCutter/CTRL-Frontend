package com.ctrlcutter.frontend.views.shortcutcreationform;

import com.ctrlcutter.frontend.util.CTRLCutterConstants;
import com.ctrlcutter.frontend.util.HorizontalDummyComponent;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Shortcut Creation")
@Route(value = "shortcut-creation")
@CssImport("./themes/ctrlcutter/shortcutForm.css")
public class ShortcutCreationForm extends VerticalLayout {

    public ShortcutCreationForm() {

        Hr horizontalLine = new Hr();
        horizontalLine.setId("dividerLine");

        HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setWidthFull();

        Image logo = getCTRLCutterLogo();
        topLayout.add(logo);

        HorizontalDummyComponent whiteSpaceComponent = new HorizontalDummyComponent("80%");

        // TODO ADD USER PROFILE ICON IN A SEPARATE LAYOUT 
        topLayout.add(whiteSpaceComponent);

        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setWidthFull();

        H1 header = new H1("Text Shortcut");
        header.setId("formHeader");

        headerLayout.add(header);

        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setId("formLayout");
        formLayout.setWidthFull();
        
        VerticalLayout formComponent = new VerticalLayout();
        formComponent.setId("formComponent");
        
        //TODO ADD OTHER SHORTCUT SELECTOR
        
        TextArea shortcutTextField = new TextArea();
        shortcutTextField.setLabel("Text");
        shortcutTextField.setId("shortcutTextField");
        
        formComponent.add(shortcutTextField);
        
        formLayout.add(formComponent);

        add(topLayout, horizontalLine, headerLayout, formLayout);

        setWidthFull();
        setHeightFull();
    }

    private Image getCTRLCutterLogo() {

        Image logo = new Image(CTRLCutterConstants.CTRLCUTTER_LOGO_FILEPATH_BLACK, "ctrlcutter logo");
        logo.setWidth("100px");
        logo.setHeight("100px");

        return logo;
    }

}
