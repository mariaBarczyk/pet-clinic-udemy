package com.springcourse.petclinic.services;

import com.springcourse.petclinic.models.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
