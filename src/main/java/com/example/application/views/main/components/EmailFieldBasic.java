package com.example.application.views.main.components;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;

@Route("email-field-basic")
public class EmailFieldBasic extends HorizontalLayout {

    public EmailFieldBasic() {
        setPadding(false);

        EmailField validEmailField = new EmailField();
        validEmailField.setLabel("Email address");
        validEmailField.getElement().setAttribute("name", "email");
        validEmailField.setValue("judith@gmx.de");
        validEmailField.setErrorMessage("Please enter a valid email address");
        validEmailField.setClearButtonVisible(true);

        add(validEmailField);

//        emailField.setPlaceholder("username@example.com");
//        emailField.setPattern("^.+@example\\.com$");

    }
}
