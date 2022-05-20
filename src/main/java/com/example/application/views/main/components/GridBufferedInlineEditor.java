package com.example.application.views.main.components;

import com.example.application.views.main.object.Person;
import com.example.application.views.main.object.ValidationMessage;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.Route;

import java.util.LinkedList;
import java.util.List;

@Route("grid-buffered-inline-editor")
public class GridBufferedInlineEditor extends VerticalLayout {

    public GridBufferedInlineEditor() {
        ValidationMessage firstNameValidationMessage = new ValidationMessage();
        ValidationMessage lastNameValidationMessage = new ValidationMessage();
        ValidationMessage emailNameValidationMessage = new ValidationMessage();

        Grid<Person> grid = new Grid<>(Person.class,false);
        Editor<Person> editor = grid.getEditor();

        Grid.Column<Person> firstNameColumn = grid
                .addColumn(Person::getFirstName).setHeader("First name")
                .setWidth("120px").setFlexGrow(0);
        Grid.Column<Person> lastNameColumn = grid.addColumn(Person::getLastName)
                .setHeader("Last name").setWidth("120px").setFlexGrow(0);
        Grid.Column<Person> emailColumn = grid.addColumn(Person::getEMail)
                .setHeader("Email");

        Grid.Column<Person> editColumn= grid.addComponentColumn(person -> {
            Button editButton = new Button("Edit");
            editButton.addClickListener(e-> {
                if(editor.isOpen())
                    editor.cancel();
                grid.getEditor().editItem(person);
            });
            return editButton;}).setWidth("150px").setFlexGrow(0);

        Binder<Person> binder = new Binder<>(Person.class);
        editor.setBinder(binder);
        editor.setBuffered(true);

        TextField firstNameField = new TextField();
        firstNameField.setWidthFull();
        binder.forField(firstNameField)
                .asRequired("First name must not be empty")
                .withStatusLabel(firstNameValidationMessage)
                .bind(Person::getFirstName, Person::setFirstName);
        firstNameColumn.setEditorComponent(firstNameField);

        TextField lastNameField = new TextField();
        lastNameField.setWidthFull();
        binder.forField(lastNameField).asRequired("Last name must not be empty")
                .withStatusLabel(lastNameValidationMessage)
                .bind(Person::getLastName,Person::setLastName);
        lastNameColumn.setEditorComponent(lastNameField);

        EmailField emailField = new EmailField();
        emailField.setWidthFull();
        binder.forField(emailField).asRequired("Email must not be empty")
                .withValidator(new EmailValidator(
                        "Please enter a valid email address"))
                .withStatusLabel(emailNameValidationMessage)
                .bind(Person::getEMail, Person::setEMail);
        emailColumn.setEditorComponent(emailField);

        Button saveButton = new Button("Save", e -> editor.save());
        Button cancelButton = new Button(VaadinIcon.CLOSE.create(),
                e-> editor.cancel());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_ICON,
                ButtonVariant.LUMO_ERROR);
        HorizontalLayout actions = new HorizontalLayout(saveButton,cancelButton);
        actions.setPadding(false);
        editColumn.setEditorComponent(actions);

        editor.addCancelListener(e-> {
            firstNameValidationMessage.setText("");
            lastNameValidationMessage.setText("");
            emailNameValidationMessage.setText("");
        });
        List<Person> people = setupPeople();
        grid.setItems(people);

        getThemeList().clear();
        getThemeList().add("spacing-s");
        add(grid,firstNameValidationMessage, lastNameValidationMessage,emailNameValidationMessage);
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
