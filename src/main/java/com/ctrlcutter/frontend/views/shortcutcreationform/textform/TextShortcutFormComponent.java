package com.ctrlcutter.frontend.views.shortcutcreationform.textform;

import java.util.Objects;

import com.ctrlcutter.frontend.entities.form.IFormShortcutEntity;
import com.ctrlcutter.frontend.entities.form.TextShortcutFormEntity;
import com.ctrlcutter.frontend.entities.rest.BasicScriptDTO;
import com.ctrlcutter.frontend.entities.shortcut.Shortcut;
import com.ctrlcutter.frontend.util.constants.CTRLCutterConstants;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;
import com.ctrlcutter.frontend.util.rest.ShortcutMapper;
import com.ctrlcutter.frontend.util.ui.ViewRedirectionUtility;
import com.ctrlcutter.frontend.views.shortcutcreationform.components.ShortcutSelector;
import com.ctrlcutter.frontend.views.shortcutmenuview.ShortcutMenuView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class TextShortcutFormComponent extends VerticalLayout {

    private ShortcutSelector selector;
    private TextArea shortcutTextField;

    public TextShortcutFormComponent() {
        setId("formComponent");

        this.selector = new ShortcutSelector();
        selector.setId("shortcutSelector");

        this.shortcutTextField = new TextArea();
        shortcutTextField.setLabel("Text");
        shortcutTextField.setId("shortcutTextField");

        Image confirmButtonIcon = new Image(CTRLCutterConstants.CONFIRM_BUTTON_ICON_FILEPATH, "confirm_icon");
        confirmButtonIcon.setId("confirmButtonIcon");

        Button confirmButton = new Button(confirmButtonIcon);
        confirmButton.setId("textFormConfirmButton");
        confirmButton.addClassName("formConfirmButton");

        confirmButton.addClickListener(e -> {
            requestShortcut();
        });

        add(shortcutTextField, selector, confirmButton);
    }

    private void requestShortcut() {
        Shortcut selectedShortcut = Objects.requireNonNull(this.selector.generateModelValue());
        String userInputText = Objects.requireNonNull(this.shortcutTextField.getValue());

        if (!userInputText.equals("")) {
            IFormShortcutEntity shortcutEntity = new TextShortcutFormEntity(selectedShortcut, userInputText);
            BasicScriptDTO scriptDTO = ShortcutMapper.mapShortcutToDTO(shortcutEntity);
            RestRequestHelper.makeShortcutRESTRequest(scriptDTO);
            ViewRedirectionUtility.redirectToView(ShortcutMenuView.class);
        }
    }
}
