package com.springsimplespasos.universidad.universidadbackend.modelo.mappers.mapstructs;

import com.springsimplespasos.universidad.universidadbackend.modelo.dtos.AlumnoDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.dtos.ProfesorDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Profesor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface ProfesorMapperConfig {
    @InheritConfiguration(name = "mapPersona")
    void mapAlumno(Profesor profesor, @MappingTarget ProfesorDTO profesorDTO);
}
