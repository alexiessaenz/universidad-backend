package com.springsimplespasos.universidad.universidadbackend.modelo.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarreraDTO {
    private Integer codigo;
    private String nombre;
    private Integer cantidad_materias;
    private Integer cantidad_anios;

}
