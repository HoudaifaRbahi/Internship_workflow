package com.app.library.services.impl;

import com.app.library.dao.property.ApartmentProperty;
import com.app.library.dto.blockdto.ApartmentsBlockDto;
import com.app.library.dto.propertydto.ApartmentPropertyDto;
import com.app.library.repository.residenceRepository.ApartmentPropertyRepository;
import com.app.library.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentPropertyService implements PropertyService<ApartmentPropertyDto> {
    @Autowired
    private ApartmentPropertyRepository apartmentPropertyRepository;

    @Override
    public ApartmentPropertyDto save(ApartmentPropertyDto propertyDto) {
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
        return apartmentProperty.map(ApartmentPropertyDto::toDto).orElseThrow(null);
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
