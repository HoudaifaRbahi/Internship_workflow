package com.app.library.services.impl;

import com.app.library.dao.property.VillaProperty;
import com.app.library.dto.propertydto.VillaPropertyDto;
import com.app.library.exceptions.EntityNotFoundException;
import com.app.library.exceptions.ErrorCodes;
import com.app.library.exceptions.InvalidEntityException;
import com.app.library.repository.residenceRepository.VillaPropertyRepository;
import com.app.library.services.PropertyService;
import com.app.library.validators.ObjectsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VillaPropertyService implements PropertyService<VillaPropertyDto> {
    @Autowired
    private VillaPropertyRepository villaPropertyRepository;


    @Override
    public VillaPropertyDto save(VillaPropertyDto propertyDto) {
        ObjectsValidator<VillaPropertyDto> dtoObjectsValidator = new ObjectsValidator<>();
        Set<String> errors = dtoObjectsValidator.validate(propertyDto);
        if (errors != null) {
            log.error("Le complex de villas n'est pas valide : {}", propertyDto);
            throw new InvalidEntityException("Le complex de villas n'est pas valide",
                    ErrorCodes.ApartmentComplex_NOT_VALID,errors);
        }

        return VillaPropertyDto.toDto(
                villaPropertyRepository.save(
                        Objects.requireNonNull(VillaPropertyDto.toEntity(propertyDto)
                )
        ));
    }

    @Override
    public VillaPropertyDto findByName(String name) {
        return null;
    }

    @Override
    public VillaPropertyDto findById(Integer id) {
        Optional<VillaProperty> villaProperty = villaPropertyRepository.findById(id);
        return villaProperty.map(VillaPropertyDto::toDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune villa avec l'ID=" + id + " existe",
                        ErrorCodes.VILLA_NOT_FOUND));
    }

    @Override
    public List<VillaPropertyDto> findAll() {
        return villaPropertyRepository.findAll().stream()
                .map(VillaPropertyDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public VillaPropertyDto update(Integer id, VillaPropertyDto propertyDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        villaPropertyRepository.deleteById(id);
    }
}
