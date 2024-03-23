package com.app.library.dto.clientdto;

import com.app.library.dao.client.CProperty;
import com.app.library.dao.client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClientDto   {
    private Integer id;
    @NotBlank(message = "Le prénom est obligatoire")
    @Size(max = 30, message = "Le prénom ne peut pas dépasser 30 caractères")
    private String firstName;

    @NotBlank(message = "Le nom de famille est obligatoire")
    @Size(max = 30, message = "Le nom de famille ne peut pas dépasser 30 caractères")
    private String lastName;

    @Email(message = "L'adresse e-mail doit être valide")
    private String mail;

    @NotBlank(message = "Le NIC est obligatoire")
    private String nic;

    @NotBlank(message = "Le numéro de téléphone est obligatoire")
    @Size(max = 10, message = "Le numéro de téléphone ne peut pas dépasser 10 caractères")
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<CProperty> cProperties;

    public static Client toEntity(ClientDto dto) {
        return dto == null ? null : Client.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .mail(dto.getMail())
                .nic(dto.getNic())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    public static ClientDto toDto(Client entity) {
        return entity == null ? null : ClientDto.builder()
                .firstName(entity.getFirstName())
                .id(entity.getId())
                .lastName(entity.getLastName())
                .mail(entity.getMail())
                .nic(entity.getNic())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }
}
