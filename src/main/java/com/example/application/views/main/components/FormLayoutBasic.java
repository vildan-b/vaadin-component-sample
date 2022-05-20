package com.example.application.views.main.components;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("form-layout-basic")
public class FormLayoutBasic extends Div {
    public FormLayoutBasic() {
        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        TextField userName = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        PasswordField confirmPassword = new PasswordField("Confirm Password");

        FormLayout formLayout = new FormLayout();
        formLayout.add(
                lastName, password,
                firstName, confirmPassword,
                userName
        );

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0",1),
                new FormLayout.ResponsiveStep("500px",2)
        );

        formLayout.setColspan(userName, 2);

        add(formLayout);

    }
}
