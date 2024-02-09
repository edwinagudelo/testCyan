package com.sbi.TestJPA.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sbi.TestJPA.models.Analisis;

@Repository
public interface AnalisisRepo  extends JpaRepository<Analisis, Integer>{

	@Query(value = "Select * From analisis Where idpeticion = :id Order By contador desc", nativeQuery = true)
	List<Analisis> traerFrecuencia(@Param("id") Integer petid);
}
