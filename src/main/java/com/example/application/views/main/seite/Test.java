package com.example.application.views.main.seite;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;

@CssImport(value = "./styles/components/form/vaadin-text-field.css", themeFor = "vaadin-text-field")
@CssImport(value = "./styles/components/form/vaadin-form-layout.css", themeFor = "vaadin-form-layout")

public class Test extends FormLayout {

    public Test() {

        FormLayout form1 = new FormLayout();
        H1 title = new H1("First Datei");
        Span nameText = new Span("Name: ");
        TextField name = new TextField();

        Span surnameText = new Span("Surname: ");
        TextField surname = new TextField();
        form1.add(title, nameText, name,  surnameText, surname);
        form1.setColspan(title,2);
        add(form1);
    }
}
