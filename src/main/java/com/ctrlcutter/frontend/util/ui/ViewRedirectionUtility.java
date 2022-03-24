package com.ctrlcutter.frontend.util.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;

public class ViewRedirectionUtility {

    public static void redirectToView(Class<? extends Component> viewClass) {
        UI.getCurrent().navigate(viewClass);
    }

    /*public static <C, T> void redirectToView(Class<? extends C> viewClass, T parameter) {
        UI.getCurrent().navigate(ShortcutOverviewView.class, parameter);
    }*/

    public static void redirectToLastView() {
        UI.getCurrent().getPage().getHistory().back();
    }
}
