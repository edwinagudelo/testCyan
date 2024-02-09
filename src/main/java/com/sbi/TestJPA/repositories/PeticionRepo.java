package com.sbi.TestJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sbi.TestJPA.models.Peticion;

@Repository
public interface PeticionRepo extends JpaRepository<Peticion, Integer> {

}
