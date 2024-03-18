package com.app.library.services;

import com.app.library.dto.clientdto.CPropertyDto;

import java.util.List;


public interface CPropertyService {
    CPropertyDto save(CPropertyDto cPropertyDto);
    CPropertyDto findByName(String name);
    CPropertyDto findById(Integer id);
    List<CPropertyDto> findAll();
    CPropertyDto update(Integer id, CPropertyDto cPropertyDto);
    void delete(Integer id);
}
