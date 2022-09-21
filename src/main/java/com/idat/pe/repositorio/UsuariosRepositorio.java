package com.idat.pe.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.modelo.Usuarios;



@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios, Long>{

}
