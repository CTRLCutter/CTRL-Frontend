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
    private PasswordStrength passwordStrength;

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
        addValueChangeListener(this::updateHelper);
    }

    public boolean isPasswordStrongEnough() {
        PasswordPolicyComparator comparator = new PasswordPolicyComparator();
        PasswordPolicy currentPolicy = this.passwordStrength.getPasswordPolicy();

        return (comparator.compare(currentPolicy, PasswordPolicy.MODERATE) >= 0);
    }

    private void updateHelper(ComponentValueChangeEvent<PasswordField, String> event) {

        this.passwordStrength = new PasswordStrength(event.getValue());
        PasswordPolicy policy = this.passwordStrength.getPasswordPolicy();

        passwordStrengthText.setText(getTranslation(policy.getTranslationkey()));
        passwordStrengthText.getStyle().set("color", policy.getTextColor());
        checkIcon.setVisible(policy.isIconVisibility());
    }
}
