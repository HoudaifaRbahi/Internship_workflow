package com.app.library.services.impl;
import com.app.library.dao.block.VillasBlock;
import com.app.library.dto.blockdto.VillasBlockDto;
import com.app.library.repository.residenceRepository.VillaBlockRepository;
import com.app.library.services.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VillaBlockService implements BlockService<VillasBlockDto> {
    @Autowired
    private VillaBlockRepository villaBlockRepository;

    @Override
    public VillasBlockDto save(VillasBlockDto blockDto) {
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
        return villaBlock.map(VillasBlockDto::toDto).orElse(null);
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
