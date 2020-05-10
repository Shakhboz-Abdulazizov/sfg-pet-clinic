package com.example.petclinicdata.repositories;

import com.example.petclinicdata.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
