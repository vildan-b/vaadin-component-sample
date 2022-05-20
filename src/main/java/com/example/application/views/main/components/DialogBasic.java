package com.example.application.views.main.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

@Route("dialog-basic")
public class DialogBasic extends Div {


    public DialogBasic() {
        Dialog dialog = new Dialog();
        dialog.setThemeName("New Employee");

        VerticalLayout dialogLayout = createDialogLayout();
        dialog.add(dialogLayout);

        Button saveButton = createSaveButton(dialog);
        Button cancelButton = new Button("Cancel", e-> dialog.close());
        dialog.add(saveButton, cancelButton);

        Button button = new Button("Show Dialog", e-> dialog.open());
        add(dialog, button);



    }

    private Button createSaveButton(Dialog dialog) {
        Button saveButton = new Button("Add", e-> dialog.close());
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return saveButton;
    }

    private VerticalLayout createDialogLayout() {
        TextField firstnameField= new TextField("First name");
        TextField lastNameField = new TextField("Last name");

        VerticalLayout dialogLayout = new VerticalLayout(firstnameField, lastNameField);
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");
        return dialogLayout;

    }
}
