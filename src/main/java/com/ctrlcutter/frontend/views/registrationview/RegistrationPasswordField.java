package com.ctrlcutter.frontend.views.registrationview;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.data.value.ValueChangeMode;

public class RegistrationPasswordField extends PasswordField {

    private Icon checkIcon;
    private Span passwordStrengthText;

    public RegistrationPasswordField() {
        setLabel(getTranslation("registration_form_password"));
        setRequired(true);
        setClassName("registrationFormField");

        Div passwordStrength = new Div();
        passwordStrengthText = new Span();
        passwordStrength.add(new Text(getTranslation("registration_pass_policy_strength") + " "), passwordStrengthText);
        setHelperComponent(passwordStrength);

        checkIcon = VaadinIcon.CHECK.create();
        checkIcon.setVisible(false);
        setSuffixComponent(checkIcon);

        setValueChangeMode(ValueChangeMode.EAGER);
        addValueChangeListener(e -> {
            String password = e.getValue();
            updateHelper(password);
        });
    }

    private void updateHelper(String password) {

        PasswordStrength passStrength = new PasswordStrength(password);
        PasswordPolicy policy = passStrength.getPasswordPolicy();

        passwordStrengthText.setText(getTranslation(policy.getTranslationkey()));
        passwordStrengthText.getStyle().set("color", policy.getTextColor());
        checkIcon.setVisible(policy.isIconVisibility());
    }
}
