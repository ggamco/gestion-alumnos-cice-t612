package com.cice.gestionalumnos.web.resource;

import com.cice.gestionalumnos.service.AlumnosService;
import com.cice.gestionalumnos.web.dto.AlumnoOldDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class AlumnosResource {

    @Autowired
    AlumnosService alumnosService;

    @RequestMapping(path = "/alumnos/validate", method = RequestMethod.POST)
    public void validate(@RequestBody(required = false) AlumnoOldDTO alumnoOld){
        log.info("Recibiendo llamado del cliente web");
        log.info(alumnoOld.toString());
        AlumnoOldDTO alumno = alumnosService.search(alumnoOld);
        if(alumno != null){
            //ok
            log.info("Hemos encontrado al alumno");
        } else {
            //ko
            log.error("Alumno no encontrado");
        }
    }

}
