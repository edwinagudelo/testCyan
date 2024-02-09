package com.sbi.TestJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sbi.TestJPA.models.Noticia;


@Repository
public interface NoticiaRepo extends JpaRepository<Noticia, Integer> {

}
