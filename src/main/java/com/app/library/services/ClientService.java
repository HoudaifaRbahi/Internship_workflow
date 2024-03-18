package com.app.library.services;

import com.app.library.dto.clientdto.ClientDto;

import java.util.List;


public interface ClientService {
    ClientDto save(ClientDto ClientDto);
    ClientDto findByName(String name);
    ClientDto findById(Integer id);
    List<ClientDto> findAll();
    ClientDto update(Integer id, ClientDto ClientDto);
    void delete(Integer id);
}
