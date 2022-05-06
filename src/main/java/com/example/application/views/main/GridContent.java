package com.example.application.views.main;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.router.Route;

import java.util.LinkedList;
import java.util.List;


@Route("grid-content")
public class GridContent extends Div {

    public GridContent() {

        Grid<Person> grid= new Grid<>(Person.class, false);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(createEmployerRenderer()).setHeader("Employee").setAutoWidth(true).setFlexGrow(0);
        grid.addColumn(Person::getProfession).setHeader("Profession").setAutoWidth(true);
        grid.addColumn(createStatusComponentRenderer()).setHeader("Status").setAutoWidth(true);

        List<Person> people = new LinkedList<>();
        Person person1= new Person("Vildan", "Bayte", "aaa@aaaa","ddddddd","Arzt ", "Available");
        people.add(person1);
        Person person2= new Person("Azra", "Bayte", "aaa@aaaa","ddddddd","Arzt ", "Busy");
        people.add(person2);
        grid.setItems(people);

        add(grid);

    }
    private static  final SerializableBiConsumer<Span, Person> statusComponentUpdater = (span, person) ->{
        boolean isAvailable = "Available".equals(person.getStatus());
        String theme = String.format("badge %s", isAvailable ? "success" : "error");
        span.getElement().setAttribute("theme", theme);
        span.setText(person.getStatus());
    };

    private ComponentRenderer<Span, Person> createStatusComponentRenderer() {
        return new ComponentRenderer<>(Span::new, statusComponentUpdater);
    }

    private static Renderer<Person> createEmployerRenderer() {

        return LitRenderer.<Person>of(
                "<vaadin-horizontal-layout style=\"align-items: center;\" theme=\"spacing\">"
                        + "<vaadin-avatar img=\"${item.pictureUrl}\" name=\"${item.fullName}\" alt=\"User avatar\"></vaadin-avatar>"
                        + "  <vaadin-vertical-layout style=\"line-height: var(--lumo-line-height-m);\">"
                        + "    <span> ${item.fullName} </span>"
                        + "    <span style=\"font-size: var(--lumo-font-size-s); color: var(--lumo-secondary-text-color);\">"
                        + "      ${item.email}" + "    </span>"
                        + "  </vaadin-vertical-layout>"
                        + "</vaadin-horizontal-layout>")
                .withProperty("pictureUrl", Person::getPictureUrl)
                .withProperty("fullName", Person::getFullName)
                .withProperty("email", Person::getEMail);

    }


}
