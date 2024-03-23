package com.app.library.dao.block;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String blockName;
    private int numberPro;
    private int avPro;

}
