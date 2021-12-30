package com.ctrlcutter.frontend.views.mainview;

import java.util.Locale;

import com.ctrlcutter.frontend.util.TranslationProvider;
import com.ctrlcutter.frontend.views.mainview.sublayouts.KeyboardContentLayout;
import com.ctrlcutter.frontend.views.mainview.sublayouts.MainContentLayout;
import com.ctrlcutter.frontend.views.mainview.sublayouts.TopLayout;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Main View")
@Route(value = "main", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {

    public MainView() {

        TranslationProvider.changeApplicationLocale(Locale.ENGLISH);
        setMargin(true);

        HorizontalLayout topLayout = new TopLayout();

        add(topLayout);

        Hr horizontalLine = new Hr();
        horizontalLine.setId("dividerLine");

        add(horizontalLine);

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setWidthFull();

        VerticalLayout mainContentLayout = new MainContentLayout();

        mainLayout.add(mainContentLayout);

        VerticalLayout keyboardContentLayout = new KeyboardContentLayout();

        mainLayout.add(keyboardContentLayout);

        add(mainLayout);

        setWidthFull();
        setHeightFull();
    }

}
