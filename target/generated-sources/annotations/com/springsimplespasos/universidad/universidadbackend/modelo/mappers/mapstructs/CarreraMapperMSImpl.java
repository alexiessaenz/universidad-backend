package com.springsimplespasos.universidad.universidadbackend.modelo.mappers.mapstructs;

import com.springsimplespasos.universidad.universidadbackend.modelo.dtos.CarreraDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-30T22:38:47-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CarreraMapperMSImpl implements CarreraMapperMS {

    @Override
    public CarreraDTO mapCarrera(Carrera carrera) {
        if ( carrera == null ) {
            return null;
        }

        CarreraDTO carreraDTO = new CarreraDTO();

        carreraDTO.setCodigo( carrera.getId() );
        carreraDTO.setCantidad_materias( carrera.getCantidadMaterias() );
        carreraDTO.setCantidad_anios( carrera.getCantidadAnios() );
        carreraDTO.setNombre( carrera.getNombre() );

        return carreraDTO;
    }
}
