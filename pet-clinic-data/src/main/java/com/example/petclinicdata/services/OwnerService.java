package com.example.petclinicdata.services;

import com.example.petclinicdata.models.Owner;


public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);


}
