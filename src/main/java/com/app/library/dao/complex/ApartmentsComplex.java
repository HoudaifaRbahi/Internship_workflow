package com.app.library.dao.complex;
import com.app.library.dao.block.ApartmentBlock;
import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@Table( name = "apartments_complex")
public class ApartmentsComplex extends Complex {
    @OneToMany(mappedBy = "apartment_complex",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApartmentBlock> blocks;
}
