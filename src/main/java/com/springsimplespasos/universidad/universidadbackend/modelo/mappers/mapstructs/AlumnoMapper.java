package com.springsimplespasos.universidad.universidadbackend.modelo.mappers.mapstructs;

import com.springsimplespasos.universidad.universidadbackend.modelo.dtos.AlumnoDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = AlumnoMapperConfig.class)
public abstract class AlumnoMapper {
    public abstract AlumnoDTO mapAlumno(Alumno alumno);
    public abstract Alumno mapAlumno(AlumnoDTO alumnoDTO);
}
