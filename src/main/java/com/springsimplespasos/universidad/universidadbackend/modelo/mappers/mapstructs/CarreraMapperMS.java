package com.springsimplespasos.universidad.universidadbackend.modelo.mappers.mapstructs;

import com.springsimplespasos.universidad.universidadbackend.modelo.dtos.CarreraDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface CarreraMapperMS {
    @Mappings({
            @Mapping(source = "id", target = "codigo"),
            @Mapping(source = "cantidadMaterias", target = "cantidad_materias"),
            @Mapping(source = "cantidadAnios", target = "cantidad_anios")
    })
    CarreraDTO mapCarrera(Carrera carrera);
}
