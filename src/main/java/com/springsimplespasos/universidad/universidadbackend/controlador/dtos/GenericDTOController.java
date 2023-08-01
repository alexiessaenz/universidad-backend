package com.springsimplespasos.universidad.universidadbackend.controlador.dtos;

import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.GenericoDAO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
//@NoArgsConstructor(force = true)
//@AllArgsConstructor
public class GenericDTOController<E,S extends GenericoDAO<E>> {
    protected final S service;
    protected final String nombreEntidad;

    public GenericDTOController(S service, String nombreEntidad) {
        this.service = service;
        this.nombreEntidad = nombreEntidad;
    }

    public List<E> obtenerTodos(){
        return (List<E>) service.findAll();
    }
    public Optional<E> ontenerPorId(Integer id){
        return (Optional<E>) service.findById(id);
    }
    public Map<String,Object> obtenerValidaciones(BindingResult result){
        Map<String, Object> validaciones = new HashMap<>();
        result.getFieldErrors()
                .forEach(error -> validaciones.put(
                        error.getField(),
                        error.getDefaultMessage()));

        return validaciones;
    }
}
