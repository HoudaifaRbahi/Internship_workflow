package com.app.library.services.impl;

import com.app.library.exceptions.EntityNotFoundException;
import com.app.library.exceptions.ErrorCodes;
import com.app.library.services.PropertyService;
import com.app.library.validators.ObjectsValidator;
import com.app.library.dao.property.ApartmentProperty;
import com.app.library.dto.propertydto.ApartmentPropertyDto;
import com.app.library.exceptions.InvalidEntityException;
import com.app.library.repository.residenceRepository.ApartmentPropertyRepository;
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
public class ApartmentPropertyService implements PropertyService<ApartmentPropertyDto> {
    @Autowired
    private ApartmentPropertyRepository apartmentPropertyRepository;

    @Override
    public ApartmentPropertyDto save(ApartmentPropertyDto propertyDto) {
        ObjectsValidator<ApartmentPropertyDto> dtoObjectsValidator=new ObjectsValidator<>();
        Set<String> errors=dtoObjectsValidator.validate(propertyDto);
        if(errors!=null){
            log.error("apartment is not valid()",propertyDto);
            throw new InvalidEntityException("the apartment is not valid",
                    ErrorCodes.APARTMENT_NOT_VALID,errors);
        }
        return ApartmentPropertyDto.toDto(
                apartmentPropertyRepository.save(
                        Objects.requireNonNull(ApartmentPropertyDto.toEntity(propertyDto)))
        );
    }

    @Override
    public ApartmentPropertyDto findByName(String name) {
        return null;
    }

    @Override
    public ApartmentPropertyDto findById(Integer id) {
        Optional<ApartmentProperty>apartmentProperty=apartmentPropertyRepository.findById(id);
        return apartmentProperty.map(ApartmentPropertyDto::toDto)
               .orElseThrow(() -> new EntityNotFoundException(
               "No Apartment with ID=" + id + " exists",ErrorCodes.APARTMENT_NOT_FOUND)
               );
    }

    @Override
    public List<ApartmentPropertyDto> findAll() {
        return apartmentPropertyRepository.findAll()
                .stream().map(ApartmentPropertyDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApartmentPropertyDto update(Integer id, ApartmentPropertyDto propertyDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        apartmentPropertyRepository.deleteById(id);
    }
}
