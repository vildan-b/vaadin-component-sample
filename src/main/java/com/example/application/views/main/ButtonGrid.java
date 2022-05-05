package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.validation.constraints.Email;

@Route("button-grid")
public class ButtonGrid extends VerticalLayout {

    private static class Person{
        private final String firstName;
        private final String lastName;
        private final String email;

        public Person(String firstName, String lastName, String email){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }
    }
    public ButtonGrid() {
        H2 users = new H2("Users");
        users.getStyle().set("margin", "0 auto 0 0");

        Button addUser = new Button("Add User");
        HorizontalLayout header = new HorizontalLayout(users, addUser);
        header.setAlignItems(Alignment.CENTER);
        header.getThemeList().clear();


        Button editProfile = new Button("Edit Profile");
        editProfile.setEnabled(false);

        Button managePermissions = new Button("Manage permissions");
        managePermissions.setEnabled(false);

        Button resetPassword = new Button("Reset password");
        resetPassword.setEnabled(false);

        Button delete = new Button("Delete");
        delete.setEnabled(false);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        delete.getStyle().set("margin-inline-start","auto");

        Grid<Person> grid = new Grid<>(Person.class, false);
        Person person = new Person("Vildan","Bayten","a@a");
        grid.setItems(person);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(Person::getFirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");
        grid.addColumn(Person::getEmail).setHeader("Email");
        grid.addSelectionListener(selection -> {
           int size = selection.getAllSelectedItems().size();
           boolean isSingleSelection = size == 1;
           editProfile.setEnabled(isSingleSelection);
           managePermissions.setEnabled(isSingleSelection);
           resetPassword.setEnabled(isSingleSelection);

           delete.setEnabled(size != 0);
        });

        HorizontalLayout footer = new HorizontalLayout(editProfile,managePermissions,resetPassword,delete);
        footer.getStyle().set("flex-wrap", "wrap");

        add(header,grid,footer);

    }
}
