package com.app.library.dao.complex;

import com.app.library.dao.block.ApartmentBlock;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table( name = "apartments_complex")
public class ApartmentsComplex extends Complex {

    @OneToMany(mappedBy = "apartment_complex",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ApartmentBlock> blocks;


}
