package com.cice.gestionalumnos.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AlumnoOld")
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoOldEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long idAlumnoOld;

    @Column(name = "nombreCompleto")
    private String nombreCompleto;

    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
}
