package com.example.application.views.main;

import com.example.application.demo.domain.UserPermissions;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;


@Route("badge-icons-only-table")
public class BadgeIconsOnlyTable extends Div {
    public BadgeIconsOnlyTable() {

        Grid<UserPermissions> grid= new Grid<>(UserPermissions.class, false);

    }
}
