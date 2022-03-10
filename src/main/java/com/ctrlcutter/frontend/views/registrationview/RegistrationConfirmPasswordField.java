package com.ctrlcutter.frontend.views.registrationview;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.data.value.ValueChangeMode;

public class RegistrationConfirmPasswordField extends PasswordField {

    private Icon confirmCheckIcon;

    public RegistrationConfirmPasswordField() {

        setLabel(getTranslation("registration_form_confirm_password"));
        setRequired(true);
        setClassName("registrationFormField");

        confirmCheckIcon = VaadinIcon.CHECK.create();
        confirmCheckIcon.setVisible(false);
        setSuffixComponent(confirmCheckIcon);

        setValueChangeMode(ValueChangeMode.EAGER);
    }

    protected void updateConfirmField(String passwordFieldValue) {
        String originalPassword = passwordFieldValue;
        String confirmedPassword = getValue();
        confirmCheckIcon.setVisible(false);

        if (originalPassword.equals(confirmedPassword)) {
            confirmCheckIcon.setVisible(true);
        }
    }
}
