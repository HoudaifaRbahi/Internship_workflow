package com.app.library.dao.property;

import com.app.library.dao.block.ApartmentBlock;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
@Table(name = "apartments")
public class ApartmentProperty extends Property {
    private int floorNumber;
    private ApartmentType apartmentType;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private ApartmentBlock apartment_block;
    // Constructors, getters, setters, etc.
}
