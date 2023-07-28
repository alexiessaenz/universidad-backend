package com.springsimplespasos.universidad.universidadbackend.modelo.dtos;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
//@RequiredArgsConstructor
//@NoArgsConstructor
@Data
public class ProfesorDTO extends PersonaDTO{
    private BigDecimal sueldo;

    public ProfesorDTO(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public ProfesorDTO(Integer id, String nombre, String apellido, @Pattern(regexp = "[0-9]+") @Size(min = 1, max = 10) String dni, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
    }
}
