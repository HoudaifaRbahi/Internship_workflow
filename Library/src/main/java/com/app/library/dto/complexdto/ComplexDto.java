package com.app.library.dto.complexdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public abstract class ComplexDto {
    private Integer id;
    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 255, message = "Le nom ne peut pas dépasser 255 caractères")
    private String name;

    @NotBlank(message = "L'emplacement est obligatoire")
    @Size(max = 255, message = "L'emplacement ne peut pas dépasser 255 caractères")
    private String location;
}
