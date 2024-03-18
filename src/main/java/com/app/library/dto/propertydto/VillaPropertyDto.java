package com.app.library.dto.propertydto;

import com.app.library.dao.property.VillaProperty;
import com.app.library.dto.blockdto.VillasBlockDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class VillaPropertyDto extends PropertyDto  {
    private String villa_type;
    private VillasBlockDto villasBlockDto;

    public static VillaProperty toEntity(VillaPropertyDto dto) {
        if(dto==null) return null;
        VillaProperty villaProperty=new VillaProperty();
        villaProperty.setStatus(dto.getStatus());
        villaProperty.setVilla_block(
                VillasBlockDto.toEntity(dto.getVillasBlockDto()));
        villaProperty.setPrice(dto.getPrice());
        villaProperty.setSize(dto.getSize());
        villaProperty.setNumber(dto.getNumber());
        villaProperty.setVilla_type(dto.getVilla_type());
        return villaProperty;
    }

    public static VillaPropertyDto toDto(VillaProperty entity) {
        if(entity==null) return null;
        VillaPropertyDto villaPropertyDto=new VillaPropertyDto();
        villaPropertyDto.setStatus(entity.getStatus());
        villaPropertyDto.setVillasBlockDto(
                VillasBlockDto.toDto(entity.getVilla_block()));
        villaPropertyDto.setPrice(entity.getPrice());
        villaPropertyDto.setSize(entity.getSize());
        villaPropertyDto.setNumber(entity.getNumber());
        villaPropertyDto.setVilla_type(entity.getVilla_type());
        villaPropertyDto.setId(entity.getPropertyId());
        return villaPropertyDto;
    }
}
