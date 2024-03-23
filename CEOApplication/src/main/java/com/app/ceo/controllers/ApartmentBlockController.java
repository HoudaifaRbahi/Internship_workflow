package com.app.ceo.controllers;



import com.app.library.dto.blockdto.ApartmentsBlockDto;
import com.app.library.services.impl.ApartmentBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartment-blocks")
public class ApartmentBlockController {

    private final ApartmentBlockService apartmentBlockService;

    @Autowired
    public ApartmentBlockController(ApartmentBlockService apartmentBlockService) {
        this.apartmentBlockService = apartmentBlockService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApartmentsBlockDto> createApartmentBlock(@RequestBody ApartmentsBlockDto blockDto) {
        ApartmentsBlockDto savedBlock = apartmentBlockService.save(blockDto);
        return new ResponseEntity<>(savedBlock, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentsBlockDto> getApartmentBlockById(@PathVariable("id") Integer id) {

            ApartmentsBlockDto apartmentBlockDto = apartmentBlockService.findById(id);
            return new ResponseEntity<>(apartmentBlockDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ApartmentsBlockDto>> getAllApartmentBlocks() {
        List<ApartmentsBlockDto> apartmentBlocks = apartmentBlockService.findAll();
        if (!apartmentBlocks.isEmpty()) {
            return new ResponseEntity<>(apartmentBlocks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApartmentsBlockDto> updateApartmentBlock(@PathVariable("id") Integer id,
                                                                   @RequestBody ApartmentsBlockDto blockDto) {
        ApartmentsBlockDto updatedBlock = apartmentBlockService.update(id, blockDto);
        if (updatedBlock != null) {
            return new ResponseEntity<>(updatedBlock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartmentBlock(@PathVariable("id") Integer id) {
        apartmentBlockService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
