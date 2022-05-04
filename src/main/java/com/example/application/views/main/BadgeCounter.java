package com.example.application.views.main;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("Badge-Counter")
public class BadgeCounter extends Div {

    public BadgeCounter() {
        Tabs tabs = new Tabs(
                createTab("Inbox", 12),
                createTab("Important", 3),
                createTab("Spam", 45),
                createTab("Archive", 23)
        );
        add(tabs);

    }

    private static Tab createTab(String labelText, int messageCount) {
        Span label = new Span(labelText);
        Span counter = new Span(String.valueOf(messageCount));
        counter.getElement().getThemeList().add("badge pill smart error");
        counter.getStyle().set("margin-inline-start", "var(--lumo-space-s)");
        // Accessible badge label
        String counterlabel = String.format("%d unread message", messageCount);
        counter.getElement().setAttribute("arial-label", counterlabel);
        counter.getElement().setAttribute("title", counterlabel);
        return new Tab(label, counter);

    }
}
