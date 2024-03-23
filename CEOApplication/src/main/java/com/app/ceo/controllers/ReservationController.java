package com.app.ceo.controllers;

import com.app.library.dto.clientdto.CPropertyDto;
import com.app.library.services.CPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cproperties")
public class ReservationController {
    private final CPropertyService cPropertyService;

    @Autowired
    public ReservationController(CPropertyService cPropertyService) {
        this.cPropertyService = cPropertyService;
    }

    @PostMapping("/save")
    public ResponseEntity<CPropertyDto> saveCProperty(@RequestBody CPropertyDto cPropertyDto) {
        CPropertyDto savedCPropertyDto = cPropertyService.save(cPropertyDto);
        return new ResponseEntity<>(savedCPropertyDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CPropertyDto> getCPropertyById(@PathVariable Integer id) {
        CPropertyDto cPropertyDto = cPropertyService.findById(id);
        if (cPropertyDto != null) {
            return new ResponseEntity<>(cPropertyDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<CPropertyDto>> getAllCProperties() {
        Iterable<CPropertyDto> cPropertyDtos = cPropertyService.findAll();
        return new ResponseEntity<>(cPropertyDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCProperty(@PathVariable Integer id) {
        cPropertyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
