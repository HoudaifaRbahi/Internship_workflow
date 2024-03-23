package com.app.library.services.impl;

import com.app.library.dao.complex.ApartmentsComplex;
import com.app.library.exceptions.EntityNotFoundException;
import com.app.library.exceptions.ErrorCodes;
import com.app.library.services.ComplexService;
import com.app.library.validators.ObjectsValidator;
import com.app.library.dto.complexdto.ApartmentsComplexDto;
import com.app.library.exceptions.InvalidEntityException;
import com.app.library.repository.residenceRepository.ApartmentComplexRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ApartmentComplexService implements ComplexService<ApartmentsComplexDto> {
    @Autowired
    private ApartmentComplexRepository apartmentComplexRepository;

    @Override
    public ApartmentsComplexDto save(ApartmentsComplexDto complexDto) {
        ObjectsValidator<ApartmentsComplexDto> dtoObjectsValidator=new ObjectsValidator<>();
        Set<String> errors=dtoObjectsValidator.validate(complexDto);
        if(errors!=null){
            log.error("the complex is not valid()",complexDto);
            throw new InvalidEntityException("the complex is not valid"
                    , ErrorCodes.ApartmentComplex_NOT_FOUND,errors);
        }
        return ApartmentsComplexDto.toDto(apartmentComplexRepository
                .save(ApartmentsComplexDto.toEntity(complexDto)));
    }

    @Override
    public ApartmentsComplexDto findByName(String name) {
        // Implement findByName logic here
        return null;
    }

    @Override
    public ApartmentsComplexDto findById(Integer id) {
        Optional<ApartmentsComplex> apartmentComplex = apartmentComplexRepository.findById(id);
        return apartmentComplex.map(ApartmentsComplexDto::toDto).orElseThrow(
                ()-> new EntityNotFoundException("No Block with ID=" + id + " exists",
                        ErrorCodes.ApartmentComplex_NOT_FOUND)
        );
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
        if(id==null){
            log.error("the provided id is null");
            return;
        }
        apartmentComplexRepository.deleteById(id);
    }
}
