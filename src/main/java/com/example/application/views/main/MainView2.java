package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementConstants;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView2 extends VerticalLayout {

    public MainView2() {
        VerticalLayout todosList = new VerticalLayout();
        TextField taskField = new TextField();
        Button addButton = new Button("Add");
        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);
        });

        addButton.addClickShortcut(Key.ENTER);

        Button deleteButton = new Button("Delete");
        deleteButton.addClickShortcut(Key.ENTER);
        deleteButton.addClickListener(click2 -> todosList.removeAll());

        //Acordion BeiSpiel
        AccordionPanel accordionPanel = new AccordionPanel();
        Accordion accordion = new Accordion();
        Span name = new Span("Sophia Williams");
        Span email = new Span("sophia.williams@company.com");
        Span phone = new Span("(501) 555-9128");
        VerticalLayout personalInformationLayout = new VerticalLayout(name, email, phone);
        personalInformationLayout.setSpacing(false);
        personalInformationLayout.setPadding(false);
        accordion.add("Personal information", personalInformationLayout);

        Accordion acordionAdresse = new Accordion();
        Span adrese1 = new Span("4027 Amber Lake Canyon");
        Span adresse2 = new Span("72333-5884 Cozy Nook");
        Span adresse3 = new Span("Arkansas");
        VerticalLayout personalAdresse = new VerticalLayout(adrese1, adresse2, adresse3);
        personalAdresse.setSpacing(false);
        personalAdresse.setPadding(false);
        acordionAdresse.add("Billing adress", personalAdresse);

        Accordion payment = new Accordion() ;
        Span payment1 = new Span("Mastercard");
        Span payment2 = new Span("1234 5678 9012 3456");
        Span payment3 = new Span("Expires 06/21\n");
        VerticalLayout paymentPanel = new VerticalLayout( payment1, payment2, payment3);
        paymentPanel.setPadding(false);
        paymentPanel.setPadding(false);
        payment.add("Payment", paymentPanel);

        accordionPanel.addContent(accordion, acordionAdresse, payment);

        Accordion accordionLink = new Accordion();

        accordionLink.add("Analytics", createContent(
                createStyledAnchor("#", "Dashboard"),
                createStyledAnchor("#", "Reports"),
                createStyledAnchor("#", "Data sources")
        ));


//Neue Beispiel-Say hello
        // Create an HTML element
        Div layout = new Div();

// Use TextField for standard text input
        TextField textField = new TextField("Your name");

// Button click listeners can be defined as lambda expressions
        Button button = new Button("Say hello",
                e -> Notification.show("Hello!"));

// Add the web components to the HTML element
        layout.add(textField, button);

        add(
                new H1("Vaadin Todo"),
                todosList,
                new HorizontalLayout(
                        taskField,
                        addButton,
                        deleteButton

                ),
                new HorizontalLayout(
                        accordionPanel
                ),
                new HorizontalLayout(
                        layout
                ),
new HorizontalLayout(accordionLink)
        );
        

    }
    private VerticalLayout createContent(Anchor ...anchors) {
        VerticalLayout content = new VerticalLayout();
        content.setPadding(false);
        content.setSpacing(false);
        content.add(anchors);

        return content;
    }        // Accordion Summary

    private Anchor createStyledAnchor(String href, String text) {
        Anchor anchor = new Anchor(href, text);
        anchor.getStyle().set(ElementConstants.STYLE_COLOR, "var(--lumo-primary-text-color)");
        anchor.getStyle().set("text-decoration", "none");

        return anchor;
    }

//    Accordion accordion = new Accordion();
//    private Component billingAddressLayout;
//    AccordionPanel billingAddressPanel = accordion.add("Billing address", billingAddressLayout);
}
