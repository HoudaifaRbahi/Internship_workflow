package com.app.library.conroller;

import com.app.library.dto.complexdto.VillasComplexDto;
import com.app.library.services.impl.VillaComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/VillaComplex")
public class VillaComplexController {
    @Autowired
    private VillaComplexService villaComplexService;
    @PostMapping("/create")
    public VillasComplexDto createVillaComplex(@RequestBody VillasComplexDto complexDto) {
        return villaComplexService.save(complexDto);
    }

    @GetMapping("/{id}")
    public VillasComplexDto getVillaComplexById(@PathVariable Integer id) {
        return villaComplexService.findById(id);
    }

    @GetMapping("/getAll")
    public Iterable<VillasComplexDto> getAllVillaComplex() {
        return villaComplexService.findAll();
    }
    @DeleteMapping("/{id}")
    public void deleteVillaComplex(@PathVariable Integer id) {
        villaComplexService.delete(id);
    }
}
