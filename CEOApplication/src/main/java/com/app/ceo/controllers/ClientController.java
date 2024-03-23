package com.app.ceo.controllers;

import com.app.library.dto.clientdto.ClientDto;
import com.app.library.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        ClientDto savedClient = clientService.save(clientDto);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    public ResponseEntity<ClientDto> getClientById(@PathVariable Integer id) {
        ClientDto clientDto = clientService.findById(id);
        if (clientDto != null) {
            return new ResponseEntity<>(clientDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> clientDtoList = clientService.findAll();
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
