package com.app.library.dto.blockdto;

import com.app.library.dao.block.ApartmentBlock;
import com.app.library.dto.complexdto.ApartmentsComplexDto;
import com.app.library.dto.propertydto.ApartmentPropertyDto;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ApartmentsBlockDto extends BlockDto {
    @PositiveOrZero(message = "Le nombre d'étages doit être positif ou nul")
    private int number_floors;

    private ApartmentsComplexDto apartment_complex;
    private Set<ApartmentPropertyDto> properties;

    public static ApartmentBlock toEntity(ApartmentsBlockDto dto) {
        if (dto == null) {
            return null;
        }

        ApartmentBlock apartmentBlock = new ApartmentBlock();
        apartmentBlock.setBlockName(dto.getBlockName());
        apartmentBlock.setNumber_floors(dto.getNumber_floors());
        apartmentBlock.setNumberPro(dto.getNumberPro());
        apartmentBlock.setApartment_complex(ApartmentsComplexDto
                .toEntity(dto.getApartment_complex()));
        apartmentBlock.setNumber_floors(dto.getNumber_floors());
        return apartmentBlock;
    }

    public static ApartmentsBlockDto toDto(ApartmentBlock entity) {
        if (entity==null) {
            return null;
        }
        ApartmentsBlockDto dto = new ApartmentsBlockDto();
        dto.setBlockName(entity.getBlockName());
        dto.setNumberPro(entity.getNumberPro());
        dto.setApartment_complex(ApartmentsComplexDto.toDto(entity.getApartment_complex()));
        dto.setAvPro(entity.getAvPro());
        dto.setId(entity.getId());
        dto.setNumber_floors(entity.getNumber_floors());
        return dto;
    }

}
