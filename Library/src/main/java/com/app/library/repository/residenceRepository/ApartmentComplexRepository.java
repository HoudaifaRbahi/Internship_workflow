package com.app.library.repository.residenceRepository;

import com.app.library.dao.complex.ApartmentsComplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentComplexRepository extends JpaRepository<ApartmentsComplex, Integer> {
}
