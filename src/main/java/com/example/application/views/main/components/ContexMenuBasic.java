package com.example.application.views.main.components;

import com.example.application.views.main.object.Person;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.Route;

import java.util.LinkedList;
import java.util.List;

@Route("contex-menu-basic")
public class ContexMenuBasic extends Div {

    public ContexMenuBasic() {
        List<Person> people = new LinkedList<>();

        Person person1= new Person("Vildan", "Bayte", "aa@aa", "sfkshfsjföaf ", "55565656");
        people.add(person1);
        Person person2= new Person("Vildan", "Bayte", "aa@aa", "sfkshfsjföaf ", "55565656");
        people.add(person2);

        Grid<Person> grid = new Grid<>();
        grid.setAllRowsVisible(true);
        grid.setItems(people);

        grid.addColumn(person -> person.getFirstName()).setHeader("First name");
        grid.addColumn(person -> person.getLastName()).setHeader("Last Name");
        grid.addColumn(person -> person.getEMail()).setHeader("Email");
        grid.addColumn(person -> person.getAddress()).setHeader("Address");
        grid.addColumn(person -> person.getPhoneNumber()).setHeader("Phone");

        GridContextMenu<Person> menu = grid.addContextMenu();
        menu.addItem("View",event -> {});
        menu.addItem("Edit",event -> {});
        menu.addItem("Delete",event -> {});

        UnorderedList content = new UnorderedList(
                new ListItem("test1"),
                new ListItem("test2"),
                new ListItem("test3")
        );
        Details details = new Details("Member ", content);
        details.setEnabled(false);










        add(grid, details);
    }
}
