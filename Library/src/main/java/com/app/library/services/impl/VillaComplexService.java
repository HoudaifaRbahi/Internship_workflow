package com.app.library.services.impl;

import com.app.library.dao.complex.VillasComplex;
import com.app.library.exceptions.EntityNotFoundException;
import com.app.library.services.ComplexService;
import com.app.library.dto.complexdto.VillasComplexDto;
import com.app.library.exceptions.ErrorCodes;
import com.app.library.exceptions.InvalidEntityException;
import com.app.library.repository.residenceRepository.VillaComplexRepository;
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
public class VillaComplexService implements ComplexService<VillasComplexDto> {
    @Autowired
    private VillaComplexRepository villaComplexRepository;


    @Override
    public VillasComplexDto save(VillasComplexDto complexDto) {
        ObjectsValidator<VillasComplexDto> dtoObjectsValidator = new ObjectsValidator<>();
        Set<String> errors = dtoObjectsValidator.validate(complexDto);
        if (errors != null) {
            log.error("Le complex de villas n'est pas valide : {}", complexDto);
            throw new InvalidEntityException("Le complex de villas n'est pas valide",
                    ErrorCodes.ApartmentComplex_NOT_VALID,errors);
        }

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
        return villaComplex.map(VillasComplexDto::toDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun complexe de villas avec l'ID=" + id + " n'existe",
                        ErrorCodes.VILLA_NOT_FOUND));
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
