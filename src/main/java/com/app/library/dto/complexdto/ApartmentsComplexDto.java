package com.app.library.dto.complexdto;

import com.app.library.dao.block.ApartmentBlock;
import com.app.library.dao.complex.ApartmentsComplex;
import com.app.library.dto.blockdto.ApartmentsBlockDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApartmentsComplexDto extends ComplexDto {

    private List<ApartmentsBlockDto> apartmentsBlockDtos;
    public static ApartmentsComplex toEntity(ApartmentsComplexDto dto) {
        if(dto==null) return null;
        ApartmentsComplex apartmentsComplex=new ApartmentsComplex();
        apartmentsComplex.setName(dto.getName());
        apartmentsComplex.setLocation(dto.getLocation());
        return apartmentsComplex;

    }

    public static ApartmentsComplexDto toDto(ApartmentsComplex entity) {
        if(entity==null) return null;
        ApartmentsComplexDto apartmentsComplexDto=new ApartmentsComplexDto();
        apartmentsComplexDto.setName(entity.getName());
        apartmentsComplexDto.setId(entity.getId());
        apartmentsComplexDto.setLocation(entity.getLocation());
        return apartmentsComplexDto;
    }
}
