package com.ctrlcutter.frontend.test.translation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.Test;

import com.ctrlcutter.frontend.util.translation.TranslationProvider;

public class TranslationProviderTest {

    private static final String EXAMPLE_TRANSLATION_KEY = "custom_macros_text_header";

    @Test
    public void testProvidedLocales() {

        final TranslationProvider translationProvider = new TranslationProvider();

        assertEquals(2, translationProvider.getProvidedLocales().size());
    }

    @Test
    public void testEnglishTranslation() {

        final TranslationProvider translationProvider = new TranslationProvider();

        assertEquals("Take Control of your Macros", translationProvider.getTranslation(EXAMPLE_TRANSLATION_KEY, Locale.ENGLISH));
    }

    @Test
    public void testGermanTranslation() {

        final TranslationProvider translationProvider = new TranslationProvider();

        assertEquals("Übernimm die Kontrolle für deine Makros", translationProvider.getTranslation(EXAMPLE_TRANSLATION_KEY, Locale.GERMAN));
    }

    @Test
    public void testMultipleTranslations() {

        final TranslationProvider translationProvider = new TranslationProvider();

        assertEquals("Take Control of your Macros", translationProvider.getTranslation(EXAMPLE_TRANSLATION_KEY, Locale.ENGLISH));
        assertEquals("Übernimm die Kontrolle für deine Makros", translationProvider.getTranslation(EXAMPLE_TRANSLATION_KEY, Locale.GERMAN));
    }

}
