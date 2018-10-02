package com.springcourse.petclinic.repositories;

import com.springcourse.petclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
