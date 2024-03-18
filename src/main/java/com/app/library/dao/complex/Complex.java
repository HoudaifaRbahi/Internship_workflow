package com.app.library.dao.complex;

import com.app.library.dao.block.Block;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Complex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String location;



    // Constructors, getters, setters, etc.
}
