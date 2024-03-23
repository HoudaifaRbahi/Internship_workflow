package com.app.library.repository.residenceRepository;

import com.app.library.dao.property.ApartmentProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentPropertyRepository extends JpaRepository<ApartmentProperty,Integer> {
}
