package com.springcourse.petclinic.bootstrap;

import com.springcourse.petclinic.models.Owner;
import com.springcourse.petclinic.models.Vet;
import com.springcourse.petclinic.services.OwnerService;
import com.springcourse.petclinic.services.VetService;
import com.springcourse.petclinic.services.map.OwnerServiceMap;
import com.springcourse.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1l);
        owner1.setFirstName("Michael");
        owner1.setLastName("Moro");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2l);
        owner2.setFirstName("Kate");
        owner2.setLastName("Burton");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1l);
        vet1.setFirstName("Robert");
        vet1.setLastName("Carter");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2l);
        vet2.setFirstName("Alice");
        vet2.setLastName("Reagan");

        vetService.save(vet2);
    }
}
