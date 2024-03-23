package com.app.library.dto.commercialdto;

import com.app.library.dao.client.CProperty;
import com.app.library.dao.commerciel.Commercial;
import com.app.library.dto.clientdto.CPropertyDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;


@Builder
@Data
@ToString
public class CommercialDto {
    private Integer id;
    private Set<CPropertyDto> cPropertyDtos;
    @NotBlank(message = "Le prénom est obligatoire")
    @Size(max = 20, message = "Le prénom ne peut pas dépasser 20 caractères")
    private String firstName;

    @NotBlank(message = "Le nom de famille est obligatoire")
    @Size(max = 20, message = "Le nom de famille ne peut pas dépasser 20 caractères")
    private String lastName;

    @NotBlank(message = "L'adresse e-mail est obligatoire")
    @Size(max = 30, message = "L'adresse e-mail ne peut pas dépasser 30 caractères")
    private String mail;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 8, max = 20, message = "Le mot de passe doit contenir entre 8 et 20 caractères")
    private String password;

    public static Commercial toEntity(CommercialDto dto) {
        if(dto==null)
        return null;
        // Convert list of CPropertyDto to List<CProperty> and set it to the entity
         Set<CProperty> properties = dto.getCPropertyDtos().stream()
                .map(CPropertyDto::toEntity)
                .collect(Collectors.toSet());
         return Commercial.builder()
         .cProperties(properties)
         .mail(dto.getMail())
         .firstName(dto.firstName)
         .lastName(dto.getLastName())
         .password(dto.getPassword()).build();


    }

    public static CommercialDto toDto(Commercial entity) {
        Set<CPropertyDto> properties = null;
        if (entity.getCProperties() != null) {
            properties = entity.getCProperties().stream()
                    .map(CPropertyDto::toDto)
                    .collect(Collectors.toSet());
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
