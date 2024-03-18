package com.app.library.dto.clientdto;

import com.app.library.dao.client.CProperty;
import com.app.library.dao.client.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import jakarta.persistence.*;

import java.util.List;

@Builder
@Data
public class ClientDto   {
    private Integer id;
    @NotBlank(message = "First name is mandatory")
    @Size(max = 30, message = "First name cannot exceed 50 characters")
    private String firstName;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 30, message = "Last name cannot exceed 50 characters")
    private String lastName;

    @Email(message = "Email should be valid")
    private String mail;

    private String nic;

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
