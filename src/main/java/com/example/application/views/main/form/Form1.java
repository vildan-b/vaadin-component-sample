package com.example.application.views.main.form;

import com.example.application.views.main.seite.Test2;
import com.example.application.views.main.seite.Test;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * File: Form1.java
 * Version: Revision:0.1
 * Last changed: 20.05.22
 * Purpose:
 * Author: vbay
 * Copyright: (C) allcompare GmbH 2022
 * Product: vaadin-component-sample
 * Package: com.example.application.views.main.form
 */


@Route("form1-test")
public class Form1 extends FormLayout {
    public Form1() {
        VerticalLayout ver =new VerticalLayout(new Test(), new Test2());
        add(ver);

    }




}
