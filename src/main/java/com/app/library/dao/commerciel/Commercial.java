package com.app.library.dao.commerciel;

import com.app.library.dao.client.CProperty;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

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
    private List<CProperty> cProperties;

    // Constructors, getters, setters, etc.
}
