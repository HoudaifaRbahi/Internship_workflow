package com.app.ceo.controllers.api;

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

@Tag(name = APP_ROOT + "/villas")
public interface VillaPropertyApi {
    @PostMapping(value = APP_ROOT+"/villas/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "enregister une villa",description = " (cette methode permet d'ajouter ou modifer une villa")
    @ApiResponses(value ={
              @ApiResponse(responseCode ="200",description = "l'objet villa crée /modifiée"),
              @ApiResponse(responseCode ="400",description = "l'objet villa n'est pas valide")
            })
    public ResponseEntity<VillaPropertyDto> createProperty(@RequestBody VillaPropertyDto propertyDto);

    @GetMapping(value = APP_ROOT+"/villas/findById",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "chercher une villa",description = " cette methode permet de chercher une villa par son id")
    @ApiResponses(value ={
            @ApiResponse(responseCode ="200",description = "l'objet villa a été trouvé dans BDD"),
            @ApiResponse(responseCode ="404",description = "aucune objet villa  a été trouvé avec cet id dans BDD")
    })
    public ResponseEntity<VillaPropertyDto> getPropertyById(@PathVariable Integer id) ;
    @GetMapping(value = APP_ROOT+"/villas/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lister tous les villa",description = "cette methode permet de lister tous les villa deja existés dans la BDD")
    @ApiResponses(value ={
            @ApiResponse(responseCode ="200",description = "l'objet villa a été trouvé dans BDD")
    })
    public ResponseEntity<List<VillaPropertyDto>> getAllProperties() ;
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Integer id) ;
}
