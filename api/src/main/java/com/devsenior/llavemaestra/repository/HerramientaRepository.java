package com.devsenior.llavemaestra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.llavemaestra.model.Herramienta;

public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {

    List<Herramienta> findAll(String nombre);

    List<Herramienta> findByActivoTrueOrderByNombreAsc();

    boolean existsByNombreIgnoreCaseAndIdNot(String nombre, Long id);

}