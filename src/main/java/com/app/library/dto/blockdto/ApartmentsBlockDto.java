package com.app.library.dto.blockdto;

import com.app.library.dao.block.ApartmentBlock;
import com.app.library.dao.property.ApartmentProperty;
import com.app.library.dto.complexdto.ApartmentsComplexDto;
import com.app.library.dto.propertydto.ApartmentPropertyDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;


@EqualsAndHashCode(callSuper = true)
@Data
public class ApartmentsBlockDto extends BlockDto {

    private int number_floors;

    private ApartmentsComplexDto apartment_complex;
    private List<ApartmentPropertyDto> properties;

    public static ApartmentBlock toEntity(ApartmentsBlockDto dto) {
        if (dto == null) {
            return null;
        }

        ApartmentBlock apartmentBlock = new ApartmentBlock();
        apartmentBlock.setBlockName(dto.getBlockName());
        apartmentBlock.setNumber_floors(dto.getNumber_floors());
        apartmentBlock.setNumberPro(dto.getNumber_pro());
        apartmentBlock.setApartment_complex(ApartmentsComplexDto.toEntity(dto.getApartment_complex()));
        apartmentBlock.setNumber_floors(dto.getNumber_floors());
        return apartmentBlock;
    }

    public static ApartmentsBlockDto toDto(ApartmentBlock entity) {
        if (entity == null) {
            return null;
        }

        ApartmentsBlockDto dto = new ApartmentsBlockDto();
        dto.setBlockName(entity.getBlockName());
        dto.setNumber_pro(entity.getNumberPro());
        dto.setAv_pro(entity.getAvPro());
        dto.setId(entity.getId());
        dto.setNumber_floors(entity.getNumber_floors());
        dto.setApartment_complex(ApartmentsComplexDto.toDto(entity.getApartment_complex()));


        return dto;
    }

}
