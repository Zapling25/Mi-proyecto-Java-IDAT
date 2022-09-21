package com.idat.pe.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long>{

}
