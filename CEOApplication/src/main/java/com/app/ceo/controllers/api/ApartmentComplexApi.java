package com.app.ceo.controllers.api;

import com.app.library.dto.complexdto.ApartmentsComplexDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.library.Utils.Constants.APP_ROOT;

@Tag(name = APP_ROOT + "/apartmentcomplex")
public interface ApartmentComplexApi {

    @PostMapping(value = APP_ROOT + "/apartmentcomplex/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Créer un complexe d'appartements", description = "Cette méthode permet de créer un nouveau complexe d'appartements")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le complexe d'appartements a été créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Le complexe d'appartements n'est pas valide")
    })
    ApartmentsComplexDto createApartmentComplex(@RequestBody ApartmentsComplexDto complexDto);

    @GetMapping(value = APP_ROOT + "/apartmentcomplex/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Obtenir un complexe d'appartements par ID", description = "Cette méthode permet d'obtenir un complexe d'appartements par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le complexe d'appartements a été trouvé dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucun complexe d'appartements trouvé avec cet ID dans la BDD")
    })
    ApartmentsComplexDto getApartmentComplexById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/apartmentcomplex/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lister tous les complexes d'appartements", description = "Cette méthode permet de lister tous les complexes d'appartements déjà existants dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les complexes d'appartements ont été trouvés dans la BDD")
    })
    List<ApartmentsComplexDto> getAllApartmentComplex();

    @DeleteMapping(value = APP_ROOT + "/apartmentcomplex/{id}")
    @Operation(summary = "Supprimer un complexe d'appartements", description = "Cette méthode permet de supprimer un complexe d'appartements par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Le complexe d'appartements a été supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun complexe d'appartements trouvé avec cet ID dans la BDD")
    })
    void deleteApartmentComplex(@PathVariable Integer id);
}

