package com.app.library.dao.property;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyId;

    private Double size;
    private Double price;
    private int number;
    @Enumerated(EnumType.STRING)
    private PropertyStatus status=PropertyStatus.AVAILABLE;

}
