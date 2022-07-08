package com.org.tcs.repository;

import com.org.tcs.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository

public interface EmployeRepo extends JpaRepository<Employe,Integer> {
 @Transactional
    Employe getByName( String name);
}
