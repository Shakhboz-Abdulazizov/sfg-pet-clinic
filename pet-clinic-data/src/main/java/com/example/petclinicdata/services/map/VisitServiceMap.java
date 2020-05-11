package com.example.petclinicdata.services.map;

import com.example.petclinicdata.models.Visit;
import com.example.petclinicdata.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet()==null || object.getPet().getOwner()==null||
                object.getPet().getOwner().getId()==null)
            throw new RuntimeException("Invalid visit");
        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
