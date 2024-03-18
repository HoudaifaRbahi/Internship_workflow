package com.app.library.dto.propertydto;

import com.app.library.dao.property.PropertyStatus;
import lombok.Data;
import lombok.ToString;

@Data
public abstract class PropertyDto {
    private Integer id;
    private Double size;

    private Double price;
    private int number;
    private PropertyStatus status=PropertyStatus.RESERVED;
}
