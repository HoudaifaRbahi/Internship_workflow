package com.app.library.repository.usersRepository;

import com.app.library.dao.commerciel.Commercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialRepository extends JpaRepository<Commercial,Integer> {
}
