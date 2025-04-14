package com.igrod.spring_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igrod.spring_study.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
