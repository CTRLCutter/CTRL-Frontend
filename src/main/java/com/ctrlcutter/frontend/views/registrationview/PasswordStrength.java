package com.ctrlcutter.frontend.views.registrationview;

import org.apache.commons.lang3.StringUtils;

public class PasswordStrength {

    private String password;

    protected PasswordStrength(String password) {
        this.password = password;
    }

    protected PasswordPolicy getPasswordPolicy() {

        if (checkStrongPasswordPolicy(password)) {
            return PasswordPolicy.STRONG;
        }

        if (checkModeratePasswordPolicy(password)) {
            return PasswordPolicy.MODERATE;
        }

        return PasswordPolicy.WEAK;
    }

    private boolean checkStrongPasswordPolicy(String password) {
        return password.length() > 9 && StringUtils.containsAny(password, "-_.:,;#'+*´`<>|^°!\"§$%&/()=?²³{[]}\\")
                && StringUtils.containsAny(password, "0123456789");
    }

    private boolean checkModeratePasswordPolicy(String password) {
        return password.length() > 5;
    }

}
