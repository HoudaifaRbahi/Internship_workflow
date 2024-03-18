package com.app.library.dao.block;

import com.app.library.dao.complex.Complex;
import com.app.library.dao.property.Property;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


import java.util.List;
@Data
@MappedSuperclass
public abstract class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String blockName; // We have used T to make this variable without a specified type
    private int numberPro; // This variable is for counting the number of properties;
    private int avPro; // This variable is for counting the number of available properties;

    // Constructors, getters, setters, etc.
}
