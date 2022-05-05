package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("button-basic")
public class ButtonBasic extends Div {
    private int counter = 0;

    public ButtonBasic() {
        Button button = new Button("Button");
        Paragraph info = new Paragraph(infoText());
        button.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        Button buttonIcon = new Button(new Icon(VaadinIcon.PLUS));
        buttonIcon.getElement().setAttribute("aria-label", "Close");


//        Image img = new Image(src, "Vaadin logo");
//        img.setWidth("100px");
//
//        Button imgButton = new Button(img);
//        imgButton.addThemeVariants(ButtonVariant.LUMO_ICON);

        // iki tane birlikte kullanilabiliyor
        //primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        button.addClickListener(clickEvent -> {
            counter += 1;
            info.setText(infoText());
        });



        HorizontalLayout horizontalLayout = new HorizontalLayout(buttonIcon,button, info);
        horizontalLayout.setAlignItems(FlexComponent.Alignment.BASELINE);
        add(horizontalLayout);
    }

    private String infoText() {
        return String.format("Clicked %d times", counter);
    }
}
