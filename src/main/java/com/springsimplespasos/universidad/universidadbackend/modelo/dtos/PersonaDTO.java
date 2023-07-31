package com.springsimplespasos.universidad.universidadbackend.modelo.dtos;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public abstract class PersonaDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    @Pattern(regexp = "[0-9]+")
    @Size(min = 1, max = 10)
    private String dni;
    private Direccion direccion;

}
