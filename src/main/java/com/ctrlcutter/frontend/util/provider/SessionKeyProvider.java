package com.ctrlcutter.frontend.util.provider;

import com.vaadin.flow.server.VaadinSession;

public class SessionKeyProvider {

    public static String getSessionKey() {
        VaadinSession session = VaadinSession.getCurrent();
        String sessionKey = (String) session.getAttribute("sessionKey");

        return sessionKey;
    }
}
