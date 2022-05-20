package com.example.application.views.main.components;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.Route;

@Route("login-basic")
public class LoginBasic extends Div {
    public LoginBasic() {
        getStyle()
        .set("background-color", "var(--lumo-contrast-5pct)")
        .set("display", "flex")
        .set("justify-content", "center")
        .set("padding", "var(--lumo-space-l)");

        LoginForm loginForm = new LoginForm();
        add(loginForm);

        loginForm.getElement().setAttribute("no-autofocus","");
    }
}
