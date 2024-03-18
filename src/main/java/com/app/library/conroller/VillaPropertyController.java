package com.app.library.conroller;

import com.app.library.dto.propertydto.VillaPropertyDto;
import com.app.library.services.impl.VillaPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villas")
public class VillaPropertyController {

    @Autowired
    private VillaPropertyService villaPropertyService;

    @PostMapping("/create")
    public ResponseEntity<VillaPropertyDto> createProperty(@RequestBody VillaPropertyDto propertyDto) {
        VillaPropertyDto savedProperty = villaPropertyService.save(propertyDto);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VillaPropertyDto> getPropertyById(@PathVariable Integer id) {
        VillaPropertyDto propertyDto = villaPropertyService.findById(id);
        if (propertyDto != null) {
            return new ResponseEntity<>(propertyDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<VillaPropertyDto>> getAllProperties() {
        List<VillaPropertyDto> propertyDtoList = villaPropertyService.findAll();
        return new ResponseEntity<>(propertyDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Integer id) {
        villaPropertyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
