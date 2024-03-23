package com.app.library.repository.residenceRepository;

import com.app.library.dao.complex.VillasComplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillaComplexRepository extends JpaRepository<VillasComplex,Integer> {
}
