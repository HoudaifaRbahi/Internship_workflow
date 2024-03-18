package com.app.library.conroller;
import com.app.library.dto.propertydto.ApartmentPropertyDto;
import com.app.library.services.impl.ApartmentPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/apartment-properties")
public class ApartmentPropertyController {
    private final ApartmentPropertyService apartmentPropertyService;

    @Autowired
    public ApartmentPropertyController(ApartmentPropertyService apartmentPropertyService) {
        this.apartmentPropertyService = apartmentPropertyService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApartmentPropertyDto> createProperty(@RequestBody ApartmentPropertyDto propertyDto) {
        ApartmentPropertyDto createdProperty = apartmentPropertyService.save(propertyDto);
        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentPropertyDto> getPropertyById(@PathVariable Integer id) {
        ApartmentPropertyDto propertyDto = apartmentPropertyService.findById(id);
        return ResponseEntity.ok(propertyDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ApartmentPropertyDto>> getAllProperties() {
        List<ApartmentPropertyDto> propertyDtos = apartmentPropertyService.findAll();
        return ResponseEntity.ok(propertyDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Integer id) {
        apartmentPropertyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
