package com.app.library.dao.property;

import com.app.library.dao.block.VillasBlock;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "villa")
public class VillaProperty extends Property{
    @Enumerated(EnumType.STRING)
    private VillaType villa_type;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private VillasBlock villa_block;

}
