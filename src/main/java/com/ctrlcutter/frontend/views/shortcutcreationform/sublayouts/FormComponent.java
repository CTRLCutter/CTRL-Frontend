package com.ctrlcutter.frontend.views.shortcutcreationform.sublayouts;

import java.util.Objects;

import org.springframework.http.ResponseEntity;

import com.ctrlcutter.frontend.entities.form.IFormShortcutEntity;
import com.ctrlcutter.frontend.entities.form.TextShortcutFormEntity;
import com.ctrlcutter.frontend.entities.rest.BasicScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.ctrlcutter.frontend.util.rest.ShortcutMapper;
import com.ctrlcutter.frontend.views.shortcutcreationform.components.ShortcutSelector;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class FormComponent extends VerticalLayout {

    private ShortcutSelector selector;
    private TextArea shortcutTextField;
    
    public FormComponent() {
        setId("formComponent");

        this.selector = new ShortcutSelector();
        selector.setId("shortcutSelector");

        this.shortcutTextField = new TextArea();
        shortcutTextField.setLabel("Text");
        shortcutTextField.setId("shortcutTextField");
        
        add(shortcutTextField, selector);
    }
    
    
    public void requestShortcut() {
        Shortcut selectedShortcut = Objects.requireNonNull(this.selector.generateModelValue());
        String userInputText = Objects.requireNonNull(this.shortcutTextField.getValue());
        
        if (!userInputText.equals("")) {
            IFormShortcutEntity shortcutEntity = new TextShortcutFormEntity(selectedShortcut, userInputText);
            BasicScriptDTO scriptDTO = ShortcutMapper.mapShortcutToDTO(shortcutEntity);
            
            ResponseEntity<String> response = RestRequestHelper.makeShortcutRESTRequest(scriptDTO);
            
            System.out.println(response.getBody());
        }
    }

}
