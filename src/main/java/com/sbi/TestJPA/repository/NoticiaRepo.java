package com.sbi.TestJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sbi.TestJPA.model.Noticia;


@Repository
public interface NoticiaRepo extends JpaRepository<Noticia, Integer> {

}
