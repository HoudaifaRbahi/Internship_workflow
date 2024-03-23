package com.app.ceo.controllers.api;

import com.app.library.dto.clientdto.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.library.Utils.Constants.APP_ROOT;

@Tag(name = APP_ROOT + "/clients")
public interface ClientApi {

    @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Créer un client", description = "Cette méthode permet de créer un nouveau client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le client a été créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Le client n'est pas valide")
    })
    ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto);

    @GetMapping(value = APP_ROOT + "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Obtenir un client par ID", description = "Cette méthode permet d'obtenir un client par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le client a été trouvé dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucun client trouvé avec cet ID dans la BDD")
    })
    ResponseEntity<ClientDto> getClientById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/clients/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lister tous les clients", description = "Cette méthode permet de lister tous les clients déjà existants dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les clients ont été trouvés dans la BDD")
    })
    ResponseEntity<List<ClientDto>> getAllClients();

    @DeleteMapping(value = APP_ROOT + "/clients/{id}")
    @Operation(summary = "Supprimer un client", description = "Cette méthode permet de supprimer un client par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Le client a été supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun client trouvé avec cet ID dans la BDD")
    })
    ResponseEntity<Void> deleteClient(@PathVariable Integer id);
}

