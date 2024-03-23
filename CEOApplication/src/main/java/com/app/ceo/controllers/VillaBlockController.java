package com.app.ceo.controllers;

import com.app.ceo.controllers.api.VillaBlockApi;
import com.app.library.dto.blockdto.VillasBlockDto;
import com.app.library.services.impl.VillaBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VillaBlockController implements VillaBlockApi {

    @Autowired
    private VillaBlockService villaBlockService;

    public VillasBlockDto createVillaBlock(@RequestBody VillasBlockDto blockDto) {
        return villaBlockService.save(blockDto);
    }

    public VillasBlockDto getVillaBlockById(@PathVariable Integer id) {
        return villaBlockService.findById(id);
    }

    public List<VillasBlockDto> getAllVillaBlocks() {
        return villaBlockService.findAll();
    }

    public void deleteVillaBlock(@PathVariable Integer id) {
        villaBlockService.delete(id);
    }
}

