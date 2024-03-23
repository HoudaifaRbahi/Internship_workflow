package com.app.library.dto.complexdto;

import com.app.library.dao.complex.VillasComplex;
import com.app.library.dto.blockdto.VillasBlockDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class VillasComplexDto extends ComplexDto {

    private Set<VillasBlockDto> villasBlockDtos;

    public static VillasComplex toEntity(VillasComplexDto dto) {
        if(dto==null) return null;
        VillasComplex villasComplex=new VillasComplex();
        villasComplex.setName(dto.getName());
        villasComplex.setLocation(dto.getLocation());
        return villasComplex;

    }

    public static VillasComplexDto toDto(VillasComplex entity) {
        if(entity==null) return null;
        VillasComplexDto villasComplexDto=new VillasComplexDto();
        villasComplexDto.setName(entity.getName());
        villasComplexDto.setId(entity.getId());
        villasComplexDto.setLocation(entity.getLocation());
        return villasComplexDto;
    }
}
