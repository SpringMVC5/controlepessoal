package com.milton.controlepessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milton.controlepessoal.entity.Manipulados;

@Repository
public interface ManipuladosRepository extends JpaRepository<Manipulados, Long>{

}
