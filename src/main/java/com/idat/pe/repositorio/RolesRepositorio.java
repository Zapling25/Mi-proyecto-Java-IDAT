package com.idat.pe.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.modelo.Roles;


@Repository
public interface RolesRepositorio extends JpaRepository<Roles, Long>{

}
