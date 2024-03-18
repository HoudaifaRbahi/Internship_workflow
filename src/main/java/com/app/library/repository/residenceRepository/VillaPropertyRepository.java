package com.app.library.repository.residenceRepository;

import com.app.library.dao.property.VillaProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillaPropertyRepository extends JpaRepository<VillaProperty,Integer> {
}
