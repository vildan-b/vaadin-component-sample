package com.example.application.views.main;

import com.example.application.views.main.object.Person;
import com.vaadin.flow.component.grid.CellFocusEvent;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import java.util.LinkedList;
import java.util.List;

@Route("grid-cell-focus")
public class GridCellFocus extends Div {

    public GridCellFocus() {
        List<Person> people = setupPeople();

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setThemeName("force-focus-outline");
        grid.addColumn(Person::getFirstName)
                .setKey("firstName")
                .setHeader("First name");
        grid.addColumn(Person::getLastName)
                .setKey("lastName")
                .setHeader("Last name");
        grid.addColumn(Person::getEMail)
                .setKey("email")
                .setHeader("Email");
        grid.addColumn(Person::getProfession)
                .setKey("profession")
                .setHeader("Profession");

        grid.setItems(people);


        TextArea textArea = new TextArea();
        textArea.setLabel("Cell focus event information");
        textArea.setReadOnly(true);
        textArea.setWidthFull();

        grid.addCellFocusListener(event -> {
            CellFocusEvent.GridSection section = event.getSection();
            String column = event.getColumn()
                    .map(Grid.Column::getKey)
                    .orElse("Not Available");
            String row = event.getItem()
                    .map(value -> String.valueOf(people.indexOf(value)))
                    .orElse("Not available");
            String fullName= event.getItem()
                    .map(Person::getFullName)
                    .orElse("Not available");
           String eventSummary = String
           .format("Section: %s%nRow: %s%nColumn: %s%nPerson: %s",
                   section, row, column, fullName);
           textArea.setValue(eventSummary);
        });
        add(grid,textArea);
    }

    private List<Person> setupPeople() {
        List<Person> people = new LinkedList<>();
        Person person1 = new Person("Vildan", "Bayte", "aaa@aaaa", "ssssss", "888888", "ddddddd", "Arzt ", "Available");
        people.add(person1);
        Person person2 = new Person("Azra", "Bayte", "aaa@aaaa", "ssssss", "888888", "ddddddd", "Arzt ", "Busy");
        people.add(person2);
        Person person3 = new Person("Gulush", "Bayte", "aaa@aaaa", "ssssss", "888888", "ddddddd", "Arzt ", "Busy");
        people.add(person3);
        Person person4 = new Person("Hilmi", "Bayte", "aaa@aaaa", "ssssss", "888888", "ddddddd", "Arzt ", "Busy");
        people.add(person4);
        Person person5 = new Person("Betul", "Bayte", "aaa@aaaa", "ssssss", "888888", "ddddddd", "Arzt ", "Busy");
        people.add(person5);
        Person person6 = new Person("Esra", "Bayte", "aaa@aaaa", "ssssss", "888888", "ddddddd", "Arzt ", "Busy");
        people.add(person6);
        return people;
    }
}
