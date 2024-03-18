package com.app.library.repository.usersRepository;

import com.app.library.dao.client.CProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPropertyRepository extends JpaRepository<CProperty,Integer> {

}
