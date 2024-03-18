package com.app.library.dto.commercialdto;

import com.app.library.dao.client.CProperty;
import com.app.library.dao.commerciel.Commercial;
import com.app.library.dto.clientdto.CPropertyDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;


@Builder
@Data
@ToString
public class CommercialDto {
    private Integer id;
    private List<CPropertyDto> cPropertyDtos;
    @NotBlank(message = "First name is mandatory")
    @Size(max = 20, message = "First name cannot exceed 20 characters")
    private String firstName;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 20, message = "First name cannot exceed 20 characters")
    private String lastName;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 30, message = "First name cannot exceed 20 characters")
    private String mail;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    public static Commercial toEntity(CommercialDto dto) {
        if(dto==null)
        return null;
        // Convert list of CPropertyDto to List<CProperty> and set it to the entity
         List<CProperty> properties = dto.getCPropertyDtos().stream()
                .map(CPropertyDto::toEntity)
                .collect(Collectors.toList());
         return Commercial.builder()
         .cProperties(properties)
         .mail(dto.getMail())
         .firstName(dto.firstName)
         .lastName(dto.getLastName())
         .password(dto.getPassword()).build();


    }

    public static CommercialDto toDto(Commercial entity) {
        List<CPropertyDto> properties = null;
        if (entity.getCProperties() != null) {
            properties = entity.getCProperties().stream()
                    .map(CPropertyDto::toDto)
                    .collect(Collectors.toList());
        }
        return CommercialDto.builder()
                .cPropertyDtos(properties)
                .mail(entity.getMail())
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .password(entity.getPassword()).build();
    }
}
