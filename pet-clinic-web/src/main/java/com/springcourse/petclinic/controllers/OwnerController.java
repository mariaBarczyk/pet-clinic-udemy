package com.springcourse.petclinic.controllers;

import com.springcourse.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "owners", "owners.html"})
    public String getOwners(Model model)
    {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index.html";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }

}
