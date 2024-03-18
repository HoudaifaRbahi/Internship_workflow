package com.app.library.services;

import com.app.library.dto.complexdto.ComplexDto;

import java.util.List;


public interface ComplexService<T extends ComplexDto> {
     T save(T complexDto);
     T findByName(String name);
     T findById(Integer id);
     List<T> findAll();
     T update(Integer id, T complexDto);
     void delete(Integer id);
}
