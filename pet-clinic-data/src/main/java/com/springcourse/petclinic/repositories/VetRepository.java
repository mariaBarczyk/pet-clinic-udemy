package com.springcourse.petclinic.repositories;

import com.springcourse.petclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
