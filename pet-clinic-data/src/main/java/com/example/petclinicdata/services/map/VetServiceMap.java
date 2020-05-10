package com.example.petclinicdata.services.map;

import com.example.petclinicdata.models.Vet;
import com.example.petclinicdata.services.SpecialityService;
import com.example.petclinicdata.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size()>0)
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId()==null)
                    speciality.setId(specialityService.save(speciality).getId());
            });
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}