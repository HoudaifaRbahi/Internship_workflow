package com.app.library.services.impl;
import com.app.library.dao.block.ApartmentBlock;
import com.app.library.dto.blockdto.ApartmentsBlockDto;
import com.app.library.exceptions.EntityNotFoundException;
import com.app.library.exceptions.ErrorCodes;
import com.app.library.repository.residenceRepository.ApartmentBlockRepository;
import com.app.library.services.BlockService;
import com.app.library.validators.ObjectsValidator;
import com.app.library.exceptions.InvalidEntityException;
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
public class ApartmentBlockService implements BlockService<ApartmentsBlockDto> {

    @Autowired
    private ApartmentBlockRepository apartmentBlockRepository;

    @Override
    public ApartmentsBlockDto save(ApartmentsBlockDto blockDto) {
        ObjectsValidator<ApartmentsBlockDto> dtoObjectsValidator=new ObjectsValidator<>();
        Set<String> errors=dtoObjectsValidator.validate(blockDto);
        if(errors!=null){
            log.error("block is not valid()",blockDto);
            throw new InvalidEntityException("the article is not valid"
                          , ErrorCodes.ApartmentBlock_NOT_VALID,errors);
        }
      return ApartmentsBlockDto.toDto(
              apartmentBlockRepository.save(
                      Objects.requireNonNull(ApartmentsBlockDto.toEntity(blockDto)))
      );
    }


    @Override
    public ApartmentsBlockDto findByName(String name) {
        return null;
    }

    @Override
    public ApartmentsBlockDto findById(Integer id) {
        Optional<ApartmentBlock> optionalBlock = apartmentBlockRepository.findById(id);
        return optionalBlock.map(ApartmentsBlockDto::toDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No Block with ID=" + id + " exists",
                        ErrorCodes.ApartmentBlock_NOT_FOUND));
    }
    @Override
    public List<ApartmentsBlockDto> findAll() {
      return apartmentBlockRepository.findAll().stream()
              .map(ApartmentsBlockDto::toDto).collect(Collectors.toList());
    }

    @Override
    public ApartmentsBlockDto update(Integer id, ApartmentsBlockDto blockDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("The given id is null");
            return;
        }
        apartmentBlockRepository.deleteById(id);
    }


}
