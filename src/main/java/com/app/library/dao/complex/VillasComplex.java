package com.app.library.dao.complex;
import com.app.library.dao.block.VillasBlock;
import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name = "villasComplex")
public class VillasComplex extends Complex{

    @OneToMany(mappedBy = "villa_complex",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VillasBlock> block;

}
