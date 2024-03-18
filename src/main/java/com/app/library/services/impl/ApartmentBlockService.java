package com.app.library.services.impl;
import com.app.library.dao.block.ApartmentBlock;
import com.app.library.dto.blockdto.ApartmentsBlockDto;
import com.app.library.repository.residenceRepository.ApartmentBlockRepository;
import com.app.library.services.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentBlockService implements BlockService<ApartmentsBlockDto> {

    @Autowired
    private ApartmentBlockRepository apartmentBlockRepository;

    @Override
    public ApartmentsBlockDto save(ApartmentsBlockDto blockDto) {
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
        return optionalBlock.map(ApartmentsBlockDto::toDto).orElse(null);
    }

    @Override
    public List<ApartmentsBlockDto> findAll() {
        return apartmentBlockRepository.findAll().stream().
                  map(ApartmentsBlockDto::toDto)
                 .collect(Collectors.toList());
    }

    @Override
    public ApartmentsBlockDto update(Integer id, ApartmentsBlockDto blockDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        apartmentBlockRepository.deleteById(id);
    }


}
