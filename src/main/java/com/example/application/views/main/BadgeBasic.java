package com.example.application.views.main;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("badge-basic")
public class BadgeBasic extends HorizontalLayout {
    public BadgeBasic() {
        Span pending = new Span("Pending");
        pending.getElement().getThemeList().add("badge small");

        Span confirmed = new Span("Confirmed");
        confirmed.getElement().getThemeList().add("badge success pill");

        Span denied = new Span("Denied");
        denied.getElement().getThemeList().add("badge error primary");

        Span onHold = new Span("On hold");
        onHold.getElement().getThemeList().add("badge contrast ");
        
        Span pending1 = new Span(createIcon(VaadinIcon.CLOCK), new Span("Pending"));
        pending1.getElement().getThemeList().add("badge");


        add(new HorizontalLayout(pending, confirmed, denied, onHold),
                new HorizontalLayout(pending1));
        setPadding(false);
        setSizeUndefined();
    }

    private Icon createIcon(VaadinIcon vaadinIcon) {
        Icon icon = vaadinIcon.create();
        icon.getStyle().set("padding", "var(--lumo-space-xs");
        return icon;
    }
}
