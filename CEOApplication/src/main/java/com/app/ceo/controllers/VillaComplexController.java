package com.app.ceo.controllers;

import com.app.ceo.controllers.api.VillaComplexApi;
import com.app.library.dto.complexdto.VillasComplexDto;
import com.app.library.services.impl.VillaComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VillaComplexController implements VillaComplexApi {
    @Autowired
    private VillaComplexService villaComplexService;
    @Override
    public VillasComplexDto createVillaComplex(@RequestBody VillasComplexDto complexDto) {
        return villaComplexService.save(complexDto);
    }
    @Override
    public VillasComplexDto getVillaComplexById(@PathVariable Integer id) {
        return villaComplexService.findById(id);
    }
    @Override
    public List<VillasComplexDto> getAllVillaComplex() {
        return villaComplexService.findAll();
    }
    @Override
    public void deleteVillaComplex(@PathVariable Integer id) {
        villaComplexService.delete(id);
    }

}
