package com.app.library.dto.blockdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public abstract class BlockDto {
    private Integer id;

    @NotBlank(message = "Le nom du bloc ne peut pas être vide")
    private String blockName;

    @PositiveOrZero(message = "Le nombre de propriétés doit être positif ou nul")
    private int numberPro;

    private int avPro;
}
