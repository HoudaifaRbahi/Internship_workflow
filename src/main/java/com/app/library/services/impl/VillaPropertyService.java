package com.app.library.services.impl;

import com.app.library.dao.property.VillaProperty;
import com.app.library.dto.propertydto.VillaPropertyDto;
import com.app.library.repository.residenceRepository.VillaPropertyRepository;
import com.app.library.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VillaPropertyService implements PropertyService<VillaPropertyDto> {
    @Autowired
    private VillaPropertyRepository villaPropertyRepository;


    @Override
    public VillaPropertyDto save(VillaPropertyDto propertyDto) {
        return propertyDto.toDto(
                villaPropertyRepository.save(
                        propertyDto.toEntity(propertyDto)
                )
        );
    }

    @Override
    public VillaPropertyDto findByName(String name) {
        return null;
    }

    @Override
    public VillaPropertyDto findById(Integer id) {
        Optional<VillaProperty> villaProperty = villaPropertyRepository.findById(id);
        return villaProperty.map(VillaPropertyDto::toDto).orElse(null);
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
