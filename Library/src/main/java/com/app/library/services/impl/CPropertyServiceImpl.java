package com.app.library.services.impl;

import com.app.library.dao.client.CProperty;
import com.app.library.dto.clientdto.CPropertyDto;
import com.app.library.exceptions.EntityNotFoundException;
import com.app.library.exceptions.ErrorCodes;
import com.app.library.exceptions.InvalidEntityException;
import com.app.library.repository.usersRepository.CPropertyRepository;
import com.app.library.services.CPropertyService;
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
public class CPropertyServiceImpl implements CPropertyService {
    @Autowired
    private CPropertyRepository propertyRepository;


    @Override
    public CPropertyDto save(CPropertyDto cPropertyDto) {
        ObjectsValidator<CPropertyDto> dtoObjectsValidator = new ObjectsValidator<>();
        Set<String> errors = dtoObjectsValidator.validate(cPropertyDto);
        if (errors != null) {
            log.error("La propriété n'est pas valide : {}", cPropertyDto);
            throw new InvalidEntityException("La propriété n'est pas valide",
                    ErrorCodes.CPROPERTY_NOT_VALID, errors);
        }

        return CPropertyDto.toDto(
                propertyRepository.save(
                        Objects.requireNonNull(CPropertyDto.toEntity(cPropertyDto))
                )
        );
    }

    @Override
    public CPropertyDto findByName(String name) {
        return null;
    }

    @Override
    public CPropertyDto findById(Integer id) {
        Optional<CProperty> cProperty = propertyRepository.findById(id);
        return cProperty.map(CPropertyDto::toDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune client propriéte avec l'ID=" + id + " n'existe",
                        ErrorCodes.CPROPERTY_NOT_FOUND));
    }

    @Override
    public List<CPropertyDto> findAll() {
        return propertyRepository.findAll().stream()
                .map(CPropertyDto::toDto).collect(Collectors.toList());
    }

    @Override
    public CPropertyDto update(Integer id, CPropertyDto cPropertyDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
           propertyRepository.deleteById(id);
    }
}
