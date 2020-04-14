package com.sbi.TestJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sbi.TestJPA.model.Peticion;

@Repository
public interface PeticionRepo extends JpaRepository<Peticion, Integer> {

}
