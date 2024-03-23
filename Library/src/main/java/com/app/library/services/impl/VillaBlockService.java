package com.app.library.services.impl;

import com.app.library.dao.block.VillasBlock;
import com.app.library.dto.blockdto.VillasBlockDto;
import com.app.library.exceptions.EntityNotFoundException;
import com.app.library.exceptions.ErrorCodes;
import com.app.library.repository.residenceRepository.VillaBlockRepository;
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
public class VillaBlockService implements BlockService<VillasBlockDto> {
    @Autowired
    private VillaBlockRepository villaBlockRepository;

    @Override
    public VillasBlockDto save(VillasBlockDto blockDto) {
        ObjectsValidator<VillasBlockDto> dtoObjectsValidator = new ObjectsValidator<>();
        Set<String> errors = dtoObjectsValidator.validate(blockDto);
        if (errors != null) {
            log.error("Le bloc de villas n'est pas valide : {}", blockDto);
            throw new InvalidEntityException("Le bloc de villas n'est pas valide",
                                          ErrorCodes.VillaBlock_NOT_VALID,errors);
        }

        return VillasBlockDto.toDto(
                villaBlockRepository.save(
                        Objects.requireNonNull(VillasBlockDto.toEntity(blockDto))
                )
        );
    }

    @Override
    public VillasBlockDto findByName(String name) {
        return null;
    }

    @Override
    public VillasBlockDto findById(Integer id) {
        Optional<VillasBlock> villaBlock = villaBlockRepository.findById(id);
        return villaBlock.map(VillasBlockDto::toDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun bloc de villas avec l'ID=" + id + " n'existe",
                        ErrorCodes.VILLA_NOT_VALID));
    }

    @Override
    public List<VillasBlockDto> findAll() {
        return   villaBlockRepository.findAll().stream()
                .map(VillasBlockDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public VillasBlockDto update(Integer id, VillasBlockDto blockDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        villaBlockRepository.deleteById(id);
    }
}
