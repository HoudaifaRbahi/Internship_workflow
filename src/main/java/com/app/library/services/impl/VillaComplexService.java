package com.app.library.services.impl;

import com.app.library.dao.complex.VillasComplex;
import com.app.library.dto.complexdto.VillasComplexDto;
import com.app.library.repository.residenceRepository.VillaComplexRepository;
import com.app.library.services.ComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VillaComplexService implements ComplexService<VillasComplexDto> {
    @Autowired
    private VillaComplexRepository villaComplexRepository;


    @Override
    public VillasComplexDto save(VillasComplexDto complexDto) {
        return VillasComplexDto.toDto(
                villaComplexRepository.save(
                        Objects.requireNonNull(VillasComplexDto.toEntity(complexDto))
                )
        );
    }

    @Override
    public VillasComplexDto findByName(String name) {
        return null;
    }

    @Override
    public VillasComplexDto findById(Integer id) {
        Optional<VillasComplex> villaComplex = villaComplexRepository.findById(id);
        return villaComplex.map(VillasComplexDto::toDto).orElse(null);
    }

    @Override
    public List<VillasComplexDto> findAll() {
        return villaComplexRepository.findAll().stream()
                .map(VillasComplexDto::toDto)
                .collect(Collectors.toList());    }

    @Override
    public VillasComplexDto update(Integer id, VillasComplexDto complexDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        villaComplexRepository.deleteById(id);
    }
}
