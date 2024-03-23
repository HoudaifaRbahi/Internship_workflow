package com.app.library.dao.commerciel;

import com.app.library.dao.client.CProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@Entity
@Table(name="commercials")
public class Commercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String mail;
    private String password;

    @OneToMany(mappedBy = "commercial",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CProperty> cProperties;

    // Constructors, getters, setters, etc.
}
