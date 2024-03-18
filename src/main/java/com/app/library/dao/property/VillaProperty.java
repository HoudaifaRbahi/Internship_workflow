package com.app.library.dao.property;

import com.app.library.dao.block.VillasBlock;
import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity
@Table(name = "villa")
public class VillaProperty extends Property{
    private String villa_type;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private VillasBlock villa_block;

}
