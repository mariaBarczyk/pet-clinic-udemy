package com.springcourse.petclinic.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vet_specialities", joinColumns =
    @JoinColumn(name = "vet_id"), inverseJoinColumns =
    @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();
}
