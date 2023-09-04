package com.example.TurismoaApplication.repositorios;

import com.example.TurismoaApplication.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa,Integer> {
}
