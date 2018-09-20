package com.springcourse.petclinic.bootstrap;

import com.springcourse.petclinic.models.Owner;
import com.springcourse.petclinic.models.PetType;
import com.springcourse.petclinic.models.Vet;
import com.springcourse.petclinic.services.OwnerService;
import com.springcourse.petclinic.services.PetTypeService;
import com.springcourse.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Moro");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kate");
        owner2.setLastName("Burton");

        ownerService.save(owner2);

        System.out.println("owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Robert");
        vet1.setLastName("Carter");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alice");
        vet2.setLastName("Reagan");

        vetService.save(vet2);

        System.out.println("vets loaded");
    }
}
