package com.app.library.dto.clientdto;

import com.app.library.dao.client.CProperty;
import com.app.library.dto.commercialdto.CommercialDto;
import com.app.library.dto.propertydto.ApartmentPropertyDto;
import com.app.library.dto.propertydto.VillaPropertyDto;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Builder
@Data
@ToString
public class CPropertyDto   {
    private Integer id;
    private VillaPropertyDto villaPropertyDto;
    private ApartmentPropertyDto apartmentPropertyDto;

    private ClientDto clientDto;
    private CommercialDto commercialDto;

    public static CProperty toEntity(CPropertyDto dto) {
        return Objects.isNull(dto) ? null : CProperty.builder()
                .commercial(CommercialDto.toEntity(dto.getCommercialDto()))
                .aProperty(ApartmentPropertyDto.toEntity(dto.getApartmentPropertyDto()))
                .client(ClientDto.toEntity(dto.getClientDto())).build();
    }

    public static CPropertyDto toDto(CProperty entity) {
        return Objects.isNull(entity) ? null : CPropertyDto.builder()
                .apartmentPropertyDto(ApartmentPropertyDto.toDto(entity.getAProperty()))
                .clientDto(ClientDto.toDto(entity.getClient()))
                .commercialDto(CommercialDto.toDto(entity.getCommercial()))
                .id(entity.getId())
                .build();
    }
}
