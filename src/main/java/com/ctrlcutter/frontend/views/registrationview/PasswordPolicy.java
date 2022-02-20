package com.ctrlcutter.frontend.views.registrationview;

public enum PasswordPolicy {

    STRONG("registration_pass_policy_strong", "#34c759", true),
    MODERATE("registration_pass_policy_moderate", "#FFD600", false),
    WEAK("registration_pass_policy_weak", "#FF3B30", false);

    private String translationkey;
    private String textColor;
    private boolean iconVisibility;

    private PasswordPolicy(String translationKey, String textColor, boolean iconVisibility) {
        this.translationkey = translationKey;
        this.textColor = textColor;
        this.iconVisibility = iconVisibility;
    }

    public String getTranslationkey() {
        return translationkey;
    }

    public String getTextColor() {
        return textColor;
    }

    public boolean isIconVisibility() {
        return iconVisibility;
    }

}
