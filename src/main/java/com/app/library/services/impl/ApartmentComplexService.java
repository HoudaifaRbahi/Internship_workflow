package com.app.library.services.impl;

import com.app.library.dao.complex.ApartmentsComplex;
import com.app.library.dto.complexdto.ApartmentsComplexDto;
import com.app.library.repository.residenceRepository.ApartmentComplexRepository;
import com.app.library.services.ComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentComplexService implements ComplexService<ApartmentsComplexDto> {
    @Autowired
    private ApartmentComplexRepository apartmentComplexRepository;

    @Override
    public ApartmentsComplexDto save(ApartmentsComplexDto complexDto) {
        return ApartmentsComplexDto.toDto(
                apartmentComplexRepository.save(
                        Objects.requireNonNull(ApartmentsComplexDto.toEntity(complexDto))
                )
        );
    }

    @Override
    public ApartmentsComplexDto findByName(String name) {
        // Implement findByName logic here
        return null;
    }

    @Override
    public ApartmentsComplexDto findById(Integer id) {
        Optional<ApartmentsComplex> apartmentComplex = apartmentComplexRepository.findById(id);
        return apartmentComplex.map(ApartmentsComplexDto::toDto).orElse(null);
    }

    @Override
    public List<ApartmentsComplexDto> findAll() {
        return apartmentComplexRepository.findAll().stream()
                .map(ApartmentsComplexDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApartmentsComplexDto update(Integer id, ApartmentsComplexDto complexDto) {
        // Implement update logic here
        return null;
    }

    @Override
    public void delete(Integer id) {
        apartmentComplexRepository.deleteById(id);
    }
}
