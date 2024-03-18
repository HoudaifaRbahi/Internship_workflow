package com.app.library.conroller;

import com.app.library.dto.complexdto.ApartmentsComplexDto;
import com.app.library.services.impl.ApartmentComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartmentComplex")
public class ApartmentComplexController {
    @Autowired
    private ApartmentComplexService apartmentComplexService;

    @PostMapping("/create")
    public ApartmentsComplexDto createApartmentComplex(@RequestBody ApartmentsComplexDto complexDto) {
        return apartmentComplexService.save(complexDto);
    }

    @GetMapping("/{id}")
    public ApartmentsComplexDto getApartmentComplexById(@PathVariable Integer id) {
        return apartmentComplexService.findById(id);
    }

    @GetMapping("/getAll")
    public Iterable<ApartmentsComplexDto> getAllApartmentComplex() {
        return apartmentComplexService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteApartmentComplex(@PathVariable Integer id) {
        apartmentComplexService.delete(id);
    }

}
