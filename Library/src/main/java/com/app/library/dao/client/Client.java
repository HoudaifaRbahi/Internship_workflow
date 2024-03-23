package com.app.library.dao.client;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "clients")
public class Client {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @Column(name = "first_name")
 private String firstName;

 @Column(name = "last_name")
 private String lastName;

 private String mail;

 private String nic;

 @Column(name = "phone_number")
 private String phoneNumber;

 @OneToMany(mappedBy = "client",cascade = CascadeType.ALL, orphanRemoval = true)
 private Set<CProperty> cProperties;


// Constructors, getters, setters, etc.
}
