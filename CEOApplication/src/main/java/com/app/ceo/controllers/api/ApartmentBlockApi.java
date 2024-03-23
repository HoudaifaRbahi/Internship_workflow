package com.app.ceo.controllers.api;


import com.app.library.dto.blockdto.ApartmentsBlockDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.library.Utils.Constants.APP_ROOT;

@Tag(name = APP_ROOT + "/apartmentblocks")
public interface ApartmentBlockApi {

    @PostMapping(value = APP_ROOT + "/apartmentblocks/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Créer un bloc d'appartements", description = "Cette méthode permet de créer un nouveau bloc d'appartements")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le bloc d'appartements a été créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Le bloc d'appartements n'est pas valide")
    })
    ResponseEntity<ApartmentsBlockDto> createApartmentBlock(@RequestBody ApartmentsBlockDto blockDto);

    @GetMapping(value = APP_ROOT + "/apartmentblocks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Obtenir un bloc d'appartements par ID", description = "Cette méthode permet d'obtenir un bloc d'appartements par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le bloc d'appartements a été trouvé dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucun bloc d'appartements trouvé avec cet ID dans la BDD")
    })
    ResponseEntity<ApartmentsBlockDto> getApartmentBlockById(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT + "/apartmentblocks/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lister tous les blocs d'appartements", description = "Cette méthode permet de lister tous les blocs d'appartements déjà existants dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les blocs d'appartements ont été trouvés dans la BDD")
    })
    ResponseEntity<List<ApartmentsBlockDto>> getAllApartmentBlocks();

    @PutMapping(value = APP_ROOT + "/apartmentblocks/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Mettre à jour un bloc d'appartements", description = "Cette méthode permet de mettre à jour un bloc d'appartements par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le bloc d'appartements a été mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun bloc d'appartements trouvé avec cet ID dans la BDD")
    })
    ResponseEntity<ApartmentsBlockDto> updateApartmentBlock(@PathVariable("id") Integer id,
                                                            @RequestBody ApartmentsBlockDto blockDto);

    @DeleteMapping(value = APP_ROOT + "/apartmentblocks/{id}")
    @Operation(summary = "Supprimer un bloc d'appartements", description = "Cette méthode permet de supprimer un bloc d'appartements par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Le bloc d'appartements a été supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun bloc d'appartements trouvé avec cet ID dans la BDD")
    })
    ResponseEntity<Void> deleteApartmentBlock(@PathVariable("id") Integer id);
}

