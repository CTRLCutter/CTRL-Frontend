package com.ctrlcutter.frontend.util.translation;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.i18n.I18NProvider;

public class TranslationProvider implements I18NProvider {

    public static final String BUNDLE_PREFIX = "ctrlcutter";

    @Override
    public List<Locale> getProvidedLocales() {

        List<Locale> locales = new ArrayList<>();

        locales.add(Locale.ENGLISH);
        locales.add(Locale.GERMAN);

        return locales;
    }

    @Override
    public String getTranslation(String translationKey, Locale locale, Object... params) {

        if (translationKey == null) {
            return "";
        }

        final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_PREFIX, locale);

        String value;

        try {

            value = bundle.getString(translationKey);

        } catch (final MissingResourceException e) {

            return "!" + locale.getLanguage() + ": " + translationKey;
        }

        if (params.length > 0) {
            value = MessageFormat.format(value, params);
        }

        return value;
    }

    public static void changeApplicationLocale(Locale locale) {
        UI.getCurrent().setLocale(locale);
    }
}
