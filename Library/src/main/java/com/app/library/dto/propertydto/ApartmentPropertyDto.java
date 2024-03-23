package com.app.library.dto.propertydto;

import com.app.library.dao.property.ApartmentProperty;
import com.app.library.dao.property.ApartmentType;
import com.app.library.dto.blockdto.ApartmentsBlockDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ApartmentPropertyDto extends PropertyDto  {

    @NotNull(message = "Le numéro d'étage ne peut pas être nul")
    @PositiveOrZero(message = "Le numéro d'étage doit être positif ou nul")
    private int floor_number;
    @NotNull(message = "Le type ne peut pas être nul")
    private ApartmentType apartmentType;

    private ApartmentsBlockDto apartmentsBlockDto;

    public static ApartmentProperty toEntity(ApartmentPropertyDto dto) {
            if(dto==null) return null;
            ApartmentProperty apartmentProperty=new ApartmentProperty();
            apartmentProperty.setStatus(dto.getStatus());
            apartmentProperty.setApartment_block(
                    ApartmentsBlockDto.toEntity(dto.getApartmentsBlockDto()));
            apartmentProperty.setFloorNumber(dto.getFloor_number());
            apartmentProperty.setPrice(dto.getPrice());
            apartmentProperty.setSize(dto.getSize());
            apartmentProperty.setNumber(dto.getNumber());
            return apartmentProperty;
    }

    public static ApartmentPropertyDto toDto(ApartmentProperty entity) {
        if(entity==null) return null;
        ApartmentPropertyDto apartmentPropertyDto=new ApartmentPropertyDto();
        apartmentPropertyDto.setStatus(entity.getStatus());
        apartmentPropertyDto.setApartmentsBlockDto
                (ApartmentsBlockDto.toDto(entity.getApartment_block()));
        apartmentPropertyDto.setFloor_number(entity.getFloorNumber());
        apartmentPropertyDto.setPrice(entity.getPrice());
        apartmentPropertyDto.setSize(entity.getSize());
        apartmentPropertyDto.setNumber(entity.getNumber());
        apartmentPropertyDto.setId(entity.getPropertyId());
        return apartmentPropertyDto;
    }
}
