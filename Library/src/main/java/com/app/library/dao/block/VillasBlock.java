package com.app.library.dao.block;

import com.app.library.dao.complex.VillasComplex;
import com.app.library.dao.property.VillaProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "villas_block")
public class VillasBlock extends Block {
    private String villasType;
    @ManyToOne
    @JoinColumn(name = "complex_id")
    private VillasComplex villa_complex;
    @OneToMany(mappedBy = "villa_block",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VillaProperty> properties;
}
