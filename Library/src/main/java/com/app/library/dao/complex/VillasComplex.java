package com.app.library.dao.complex;

import com.app.library.dao.block.VillasBlock;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "villasComplex")
public class VillasComplex extends Complex{

    @OneToMany(mappedBy = "villa_complex",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VillasBlock> block;

}
