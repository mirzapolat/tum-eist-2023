package de.tum.in.ase.pse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterYodaController {

    // TODO 1.1 Remove endpoint responsible for training apprentices
    //  from this Controller and move it to ObiWanKenobiController

    @GetMapping("/find-apprentices")
    public String findNewApprentices() {
        return "Looking for new apprentices...";
    }

}

