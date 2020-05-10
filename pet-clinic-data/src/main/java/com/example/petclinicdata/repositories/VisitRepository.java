package com.example.petclinicdata.repositories;

import com.example.petclinicdata.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
