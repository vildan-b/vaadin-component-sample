package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Route("grid-dynamic-height")
public class GridDynamicHeight extends Div {
    private static final List<Person> invitedPeople= new ArrayList<>();
    
    private static Grid<Person> grid;
    private static Div hint;
    
    public GridDynamicHeight() {
        this.setupPeople();
    this.setupInvitationForm();
    this.setupGrid();
    }

    private List<Person> setupPeople() {
        List<Person> people = new LinkedList<>();
        Person person1= new Person("Vildan", "Bayte", "aaa@aaaa","ssssss","888888","ddddddd","Arzt ", "Available");
        people.add(person1);
        Person person2= new Person("Azra", "Bayte", "aaa@aaaa","ssssss","888888","ddddddd","Arzt ", "Busy");
        people.add(person2);
        return people;
    }

    private void setupGrid() {
        List<Person> people = this.setupPeople();
        grid = new Grid<>(Person.class, false);
        grid.setAllRowsVisible(true);
        grid.addColumn(Person::getFullName).setHeader("Name");
        grid.addColumn(Person::getEMail).setHeader("Email");
        grid.addColumn(Person::getPhoneNumber).setHeader("Phone");
        grid.addColumn( new ComponentRenderer<>(Button::new, ((button, person) -> {
            button.addThemeVariants(ButtonVariant.LUMO_ICON,
                    ButtonVariant.LUMO_ERROR,
                    ButtonVariant.LUMO_TERTIARY);
            button.setIcon(new Icon(VaadinIcon.TRASH));
        }))).setHeader("Manage");
        grid.setItems(people);

        hint = new Div();
        hint.setText("No invitation has been sent");
        hint.getStyle().set("padding", "var(--lumo-size-l)")
                .set("text-align","center").set("font-style","italic")
                .set("color", "var(--lumo-contrast-70pct)");

        add(hint,grid);
    }

    private void setupInvitationForm() {

        List<Person> people = this.setupPeople();

        ComboBox<Person> comboBox = new ComboBox<>();
        comboBox.setItems(people);
        comboBox.setItemLabelGenerator(Person::getFullName);

        Button button = new Button("Send Invite");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(e->{
            sendInvitation(comboBox.getValue());
            comboBox.setValue(null);
        });
        HorizontalLayout layout = new HorizontalLayout(comboBox, button);
        layout.setFlexGrow(1, comboBox);
        add(layout);
        
    }

    private void sendInvitation(Person person) {
        if (person == null || invitedPeople.contains(person)){
            return;
//            invitedPeople.add(person);
//            this.refreshGrid();
        }
    }

    private void refreshGrid() {
        if(invitedPeople.size() > 0){
            grid.setVisible(true);
            hint.setVisible(false);
            grid.getDataProvider().refreshAll();
        } else {
            grid.setVisible(false);
            hint.setVisible(false);
        }
    }
}
