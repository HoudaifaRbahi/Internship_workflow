package com.app.library.services.impl;

import com.app.library.dao.client.Client;
import com.app.library.exceptions.EntityNotFoundException;
import com.app.library.repository.usersRepository.ClientRepository;
import com.app.library.dto.clientdto.ClientDto;
import com.app.library.exceptions.ErrorCodes;
import com.app.library.exceptions.InvalidEntityException;
import com.app.library.services.ClientService;
import com.app.library.validators.ObjectsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto save(ClientDto clientDto) {
        ObjectsValidator<ClientDto> dtoObjectsValidator=new ObjectsValidator<>();
        Set<String> errors=dtoObjectsValidator.validate(clientDto);
        if(errors!=null){
            log.error("the client is not valid()",clientDto);
            throw new InvalidEntityException("the client is not valid"
                    , ErrorCodes.CLIENT_NOT_VALID,errors);
        }
        return ClientDto.toDto(
                clientRepository.save(
                        Objects.requireNonNull(ClientDto.toEntity(clientDto))
                )
        );
    }

    @Override
    public ClientDto findByName(String name) {
        return null;
    }

    @Override
    public ClientDto findById(Integer id) {
        Optional<Client>client=clientRepository.findById(id);
        return client.map(ClientDto::toDto).orElseThrow(
                ()->new EntityNotFoundException("the client with this id "
                        +id+"is not founded" +ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::toDto).collect(Collectors.toList());
    }

    @Override
    public ClientDto update(Integer id, ClientDto ClientDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
       clientRepository.deleteById(id);
    }
}
