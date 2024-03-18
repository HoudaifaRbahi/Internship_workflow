package com.app.library.dao.client;

import com.app.library.dao.commerciel.Commercial;
import com.app.library.dao.property.ApartmentProperty;
import com.app.library.dao.property.VillaProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name = "clients_properties")
public class CProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne
    private Commercial commercial;

    @OneToOne
    private VillaProperty vProperty;

    @OneToOne
    private ApartmentProperty aProperty;


    // Constructors, getters, setters, etc.


}
