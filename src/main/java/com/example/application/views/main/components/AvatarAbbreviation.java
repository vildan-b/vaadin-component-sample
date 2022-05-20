package com.example.application.views.main.components;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@Route("avatar-abbreviation")
public class AvatarAbbreviation extends Div {

    public AvatarAbbreviation() {
        Avatar avatarName = new Avatar("Augusta Ada King");

        Avatar avatarAbbr = new Avatar("Augusta Ada King");
        avatarAbbr.setAbbreviation("AK");

        add(avatarName,avatarAbbr);


//        Avatar user = new Avatar("Vildan Bayt");
//        String pictureUrl = "https://naturschutz.ch/news/gesellschaft/beeindruckende-bilder-beim-fotowettbewerb-rund-um-europas-natur/127586";
//        user.setImage(pictureUrl);
//
//        Avatar company = new Avatar("Company Inc");
//        StreamResource imageResource = new StreamResource(
//                "Bison.jpg",
//                () -> getClass().getResourceAsStream("/Downloads/Bison.jpg")
//        );
//        company.setImageResource(imageResource);

    }
}
