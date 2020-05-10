package com.example.petclinicdata.repositories;

import com.example.petclinicdata.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
