package com.app.ceo.controllers.api;

import com.app.library.dto.propertydto.ApartmentPropertyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.library.Utils.Constants.APP_ROOT;

@Tag(name = APP_ROOT + "/apartments")
public interface ApartmentPropertyApi {

    @PostMapping(value = APP_ROOT + "/apartments/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Créer une propriété d'appartement", description = "Cette méthode permet de créer une nouvelle propriété d'appartement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La propriété d'appartement a été créée avec succès"),
            @ApiResponse(responseCode = "400", description = "La propriété d'appartement n'est pas valide")
    })
    ResponseEntity<ApartmentPropertyDto> createProperty(@RequestBody ApartmentPropertyDto propertyDto);

    @GetMapping(value = APP_ROOT + "/apartments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Obtenir une propriété d'appartement par ID", description = "Cette méthode permet d'obtenir une propriété d'appartement par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La propriété d'appartement a été trouvée dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucune propriété d'appartement trouvée avec cet ID dans la BDD")
    })
    ResponseEntity<ApartmentPropertyDto> getPropertyById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/apartments/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lister toutes les propriétés d'appartement", description = "Cette méthode permet de lister toutes les propriétés d'appartement déjà existantes dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les propriétés d'appartement ont été trouvées dans la BDD")
    })
    ResponseEntity<List<ApartmentPropertyDto>> getAllProperties();

    @DeleteMapping(value = APP_ROOT + "/apartments/{id}")
    @Operation(summary = "Supprimer une propriété d'appartement", description = "Cette méthode permet de supprimer une propriété d'appartement par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "La propriété d'appartement a été supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune propriété d'appartement trouvée avec cet ID dans la BDD")
    })
    ResponseEntity<Void> deleteProperty(@PathVariable Integer id);
}

