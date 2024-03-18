package com.app.library.services;

import com.app.library.dto.blockdto.BlockDto;

import java.util.List;


public interface BlockService<T> {
     T save(T blockDto);
     T findByName(String name);
     T findById(Integer id);
     List<T> findAll();
     T update(Integer id, T blockDto);
     void delete(Integer id);
}
