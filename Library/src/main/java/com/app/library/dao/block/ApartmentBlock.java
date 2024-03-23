package com.app.library.dao.block;

import com.app.library.dao.complex.ApartmentsComplex;
import com.app.library.dao.property.ApartmentProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ApartmentBlock")
@ToString(callSuper = true)
public class ApartmentBlock extends Block {
    private int number_floors;
    @ManyToOne
    @JoinColumn(name = "complex_id")
    private ApartmentsComplex apartment_complex;

    @OneToMany(mappedBy = "apartment_block",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ApartmentProperty> properties;
}
