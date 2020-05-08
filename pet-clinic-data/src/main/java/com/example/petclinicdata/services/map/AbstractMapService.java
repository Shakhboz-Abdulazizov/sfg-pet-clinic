package com.example.petclinicdata.services.map;

import com.example.petclinicdata.models.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    private HashMap<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null)
                object.setId(nextInt());
            map.put(object.getId(), object);
        } else throw new RuntimeException("Object ca not be NULL");

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Long nextInt() {
        Long nextInt  = null;
        try {
            nextInt = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextInt = 1L;
        }

        return nextInt;
    }
}
