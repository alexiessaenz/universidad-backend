package com.springsimplespasos.universidad.universidadbackend.modelo.dtos;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class EmpleadoDTO extends PersonaDTO{
    @Positive
    private BigDecimal sueldo;
    private TipoEmpleado tipoEmpleado;

}
