package com.cice.gestionalumnos.service.impl;

import com.cice.gestionalumnos.repository.dao.AlumnosOldDAO;
import com.cice.gestionalumnos.repository.entity.AlumnoOldEntity;
import com.cice.gestionalumnos.service.AlumnosService;
import com.cice.gestionalumnos.web.dto.AlumnoOldDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    @Autowired
    AlumnosOldDAO alumnosOldDAO;

    @Override
    public AlumnoOldDTO search(AlumnoOldDTO alumno) {

        String nombreCompleto = generateFullName(alumno);
        String fechaNacimiento = alumno.getFechaNacimiento();

        AlumnoOldDTO alumnoOldDTO = null;

        Optional<AlumnoOldEntity> alumnoOptional = alumnosOldDAO.findByNombreCompletoAndFechaNacimiento(nombreCompleto, fechaNacimiento);
        if(alumnoOptional.isPresent()){
            alumnoOldDTO = convertEntityToDto(alumnoOptional.get());
        }

        return alumnoOldDTO;
    }

    private String generateFullName(AlumnoOldDTO alumno) {
        return String.format("%s1 %s2, %s3", alumno.getPrimerApellido(),alumno.getSegundoApellido(),alumno.getNombre());
    }

    private AlumnoOldDTO convertEntityToDto(AlumnoOldEntity entity){
        return new AlumnoOldDTO();
    }
}
