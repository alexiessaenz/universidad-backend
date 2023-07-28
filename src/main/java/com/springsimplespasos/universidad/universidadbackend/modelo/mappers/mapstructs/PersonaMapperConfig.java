package com.springsimplespasos.universidad.universidadbackend.modelo.mappers.mapstructs;

import com.springsimplespasos.universidad.universidadbackend.modelo.dtos.PersonaDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface PersonaMapperConfig {
    void mapPersona(Persona persona, @MappingTarget PersonaDTO personaDTO);
}
