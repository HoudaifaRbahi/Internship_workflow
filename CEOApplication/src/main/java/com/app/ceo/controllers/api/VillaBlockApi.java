package com.app.ceo.controllers.api;

import com.app.library.dto.blockdto.VillasBlockDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.library.Utils.Constants.APP_ROOT;

@Tag(name = APP_ROOT + "/villablocks")
public interface VillaBlockApi {

    @PostMapping(value = APP_ROOT + "/villablocks/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Créer un bloc de villas", description = "Cette méthode permet de créer un nouveau bloc de villas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le bloc de villas a été créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Le bloc de villas n'est pas valide")
    })
    VillasBlockDto createVillaBlock(@RequestBody VillasBlockDto blockDto);

    @GetMapping(value = APP_ROOT + "/villablocks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Obtenir un bloc de villas par ID", description = "Cette méthode permet d'obtenir un bloc de villas par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le bloc de villas a été trouvé dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucun bloc de villas trouvé avec cet ID dans la BDD")
    })
    VillasBlockDto getVillaBlockById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/villablocks/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lister tous les blocs de villas", description = "Cette méthode permet de lister tous les blocs de villas déjà existants dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les blocs de villas ont été trouvés dans la BDD")
    })
    List<VillasBlockDto> getAllVillaBlocks();

    @DeleteMapping(value = APP_ROOT + "/villablocks/{id}")
    @Operation(summary = "Supprimer un bloc de villas", description = "Cette méthode permet de supprimer un bloc de villas par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Le bloc de villas a été supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun bloc de villas trouvé avec cet ID dans la BDD")
    })
    void deleteVillaBlock(@PathVariable Integer id);
}

