package com.app.library.dto.propertydto;

import com.app.library.dao.property.PropertyStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public abstract class PropertyDto {
    @NotNull(message = "L'ID ne peut pas être nul")
    private Integer id;

    @NotNull(message = "La taille ne peut pas être nulle")
    @PositiveOrZero(message = "La taille doit être positive ou nulle")
    private Double size;

    @NotNull(message = "Le prix ne peut pas être nul")
    @PositiveOrZero(message = "Le prix doit être positif ou nul")
    private Double price;

    @NotNull(message = "Le numéro ne peut pas être nul")
    @PositiveOrZero(message = "Le numéro doit être positif ou nul")
    private int number;

    private PropertyStatus status ;
}
