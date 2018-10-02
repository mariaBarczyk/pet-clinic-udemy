package com.springcourse.petclinic.bootstrap;

import com.springcourse.petclinic.models.*;
import com.springcourse.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedRadiolgy = specialityService.save(radiology);
        Speciality savedSugery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Moro");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("12356788");

        Pet mikesPet = new Pet();
        mikesPet.setName("Mitsy");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner1);
        owner1.getPets().add(mikesPet);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kate");
        owner2.setLastName("Burton");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("12356788");

        Pet kateCat = new Pet();
        kateCat.setName("Molly");
        kateCat.setPetType(savedCatPetType);
        kateCat.setBirthDate(LocalDate.now());
        kateCat.setOwner(owner2);
        owner2.getPets().add(kateCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(kateCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Robert");
        vet1.setLastName("Carter");
        vet1.getSpecialities().add(savedRadiolgy);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alice");
        vet2.setLastName("Reagan");
        vet2.getSpecialities().add(savedSugery);

        vetService.save(vet2);

        System.out.println("vets loaded");
    }
}
