package com.app.library.dao.property;
import com.app.library.dao.block.ApartmentBlock;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "apartments")
public class ApartmentProperty extends Property {
    private int floorNumber;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private ApartmentBlock apartment_block;
    // Constructors, getters, setters, etc.
}
