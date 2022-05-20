package com.example.application.views.main.seite;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@CssImport(value = "./styles/components/form/vaadin-form-layout.css", themeFor = "vaadin-form-layout")


public class Test2 extends FormLayout {
    public Test2() {

        HorizontalLayout schoolBerich = new HorizontalLayout();

        H4 title = new H4("School Information");

        Span nameHighschool = new Span("high School: ");
        TextField school = new TextField();

        Span nameUniversty = new Span("Universty: ");
        TextField universty = new TextField();
    schoolBerich.add(title,nameHighschool,school,nameUniversty,universty);

        add(schoolBerich);
    }
}
