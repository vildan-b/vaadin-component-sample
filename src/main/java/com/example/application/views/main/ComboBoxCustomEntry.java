package com.example.application.views.main;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("combo-box-custom-entry")
public class ComboBoxCustomEntry extends Div {
    public ComboBoxCustomEntry() {
        ComboBox<String> comboBox = new ComboBox<>("Browser");
        comboBox.setAllowCustomValue(true);
        add(comboBox);
        comboBox.setItems("Chrome", "Test", "Test3");
        comboBox.setHelperText("Select or type a browser");
        //    comboBox.getStyle().set("--vaadin-combo-box-overlay-width", "350px");
        // comboBox.setPlaceholder("Select employee");



    }
}
