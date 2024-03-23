package com.app.ceo.controllers.api;

import com.app.library.dto.complexdto.VillasComplexDto;
import com.app.library.dto.propertydto.VillaPropertyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.library.Utils.Constants.APP_ROOT;

@Tag(name = APP_ROOT + "/villasComplex")
public interface VillaComplexApi {
    @PostMapping(value = APP_ROOT+"/villasComplex/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "enregistrer un complexe des villas", description = "cette méthode permet d'ajouter ou modifier un complexe")
    @ApiResponses(value ={
            @ApiResponse(responseCode ="200", description = "l'objet complexe créé/modifié"),
            @ApiResponse(responseCode ="400", description = "l'objet complexe n'est pas valide")
    })
    public VillasComplexDto createVillaComplex(@RequestBody VillasComplexDto complexDto);
    @GetMapping(value = APP_ROOT+"/villasComplex/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "chercher un complexe", description = "cette méthode permet de chercher une complexe par son ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode ="200", description = "l'objet complexe a été trouvé dans la BDD"),
            @ApiResponse(responseCode ="404", description = "aucun objet complexe n'a été trouvé avec cet ID dans la BDD")
    })
    VillasComplexDto getVillaComplexById(@PathVariable Integer id);
    @GetMapping(value = APP_ROOT+"/villasComplex/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lister tous les complexes", description = "cette méthode permet de lister tous les complexe des villas déjà existés dans la BDD")
    @ApiResponses(value ={
            @ApiResponse(responseCode ="200", description = "les objets complexe ont été trouvés dans la BDD")
    })
    List<VillasComplexDto> getAllVillaComplex();
    @DeleteMapping(value = APP_ROOT+"/villasComplex/{id}")
    @Operation(summary = "Supprimer un complexe", description = "cette méthode permet de supprimer un complex par son ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode ="204", description = "le complexe a été supprimée avec succès"),
            @ApiResponse(responseCode ="404", description = "aucun complexe trouvée avec cet ID dans la BDD")
    })
     void deleteVillaComplex(@PathVariable Integer id);

}
