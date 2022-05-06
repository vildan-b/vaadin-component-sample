package com.example.application.views.main;

import com.example.application.views.main.object.Person;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.grid.dnd.GridDropLocation;
import com.vaadin.flow.component.grid.dnd.GridDropMode;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.Route;

import java.util.LinkedList;
import java.util.List;

@Route("grid-column-reordering")
public class GridRowReordering extends Div {
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
    private Person draggendItem;

    public GridRowReordering() {

        Grid<Person> grid = setupGrid();
        List<Person> people = setupPeople();
        GridListDataView<Person> dataView = grid.setItems(people);

        grid.setDropMode(GridDropMode.BETWEEN);
        grid.setRowsDraggable(true);

        grid.addDragStartListener(
                e->draggendItem = e.getDraggedItems().get(0));
        grid.addDropListener(e->{
           Person targetPerson = e.getDropTargetItem().orElse(null);
            GridDropLocation dropLocation = e.getDropLocation();

            boolean personWasDroppedOtoItself = draggendItem.equals(targetPerson);
            if (targetPerson == null || personWasDroppedOtoItself)
                return;

            dataView.removeItem(draggendItem);
            if(dropLocation == GridDropLocation.BELOW){
                dataView.addItemAfter(draggendItem,targetPerson);
            } else {
                dataView.addItemBefore(draggendItem,targetPerson);
            }
        });
        grid.addDragEndListener(e->draggendItem=null);

        add(grid);

    }
    private static Grid<Person> setupGrid() {
        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.addColumn(createAvatarRenderer()).setHeader("Image")
                .setAutoWidth(true).setFlexGrow(0);
        grid.addColumn(Person::getFirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");
        grid.addColumn(Person::getEMail).setHeader("Email");

        return grid;
    }

    private static Renderer<Person> createAvatarRenderer() {
        return LitRenderer.<Person>of(
                "<vaadin-avatar img=\"${item.pictureUrl}\" name=\"${item.fullName}\" alt=\"User avatar\"></vaadin-avatar>")
                .withProperty("pictureUrl", Person::getPictureUrl);
    }

}
