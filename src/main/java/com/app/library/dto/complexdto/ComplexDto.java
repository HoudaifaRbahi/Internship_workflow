package com.app.library.dto.complexdto;

import lombok.Data;

@Data
public abstract class ComplexDto {
    private Integer id;
    private String name;
    private String location;
}
