package com.app.library.repository.residenceRepository;

import com.app.library.dao.block.VillasBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillaBlockRepository extends JpaRepository<VillasBlock,Integer> {

}
