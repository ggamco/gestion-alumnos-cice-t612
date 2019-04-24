package com.cice.gestionalumnos.repository.dao;

import com.cice.gestionalumnos.repository.entity.AlumnoOldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnosOldDAO extends JpaRepository<AlumnoOldEntity, Long> {

    Optional<AlumnoOldEntity> findByNombreCompletoAndFechaNacimiento(String nombreCompleto, String fechaNacimiento);
}
