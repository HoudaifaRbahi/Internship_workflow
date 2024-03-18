package com.app.library.repository.residenceRepository;

import com.app.library.dao.block.ApartmentBlock;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ApartmentBlockRepository extends JpaRepository<ApartmentBlock,Integer> {
}
