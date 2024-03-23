package com.app.library.dto.blockdto;

import com.app.library.dao.block.VillasBlock;
import com.app.library.dto.complexdto.VillasComplexDto;
import com.app.library.dto.propertydto.VillaPropertyDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class VillasBlockDto extends BlockDto  {
    private VillasComplexDto villasComplexDto;

    private Set<VillaPropertyDto> propertyDtos;

    public static VillasBlock toEntity(VillasBlockDto dto) {
        if (dto == null) {
            return null;
        }

        VillasBlock villasBlock = new VillasBlock();
        villasBlock.setBlockName(dto.getBlockName());
        villasBlock.setVilla_complex(VillasComplexDto.toEntity(dto.getVillasComplexDto()));
        return villasBlock;
    }

    public static VillasBlockDto toDto(VillasBlock entity) {
        if (entity == null) {
            return null;
        }

        VillasBlockDto dto = new VillasBlockDto();
        dto.setBlockName(entity.getBlockName());
        dto.setId(entity.getId());
        dto.setVillasComplexDto(VillasComplexDto.toDto(entity.getVilla_complex()));
        return dto;
    }
}

