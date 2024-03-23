package com.app.library.services;

import com.app.library.dto.propertydto.PropertyDto;

import java.util.List;


public interface PropertyService<T extends PropertyDto> {
    T save(T propertyDto);
    T findByName(String name);
    T findById(Integer id);
    List<T> findAll();
    T update(Integer id, T propertyDto);
    void delete(Integer id);
}
