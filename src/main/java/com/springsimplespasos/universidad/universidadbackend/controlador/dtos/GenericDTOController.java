package com.springsimplespasos.universidad.universidadbackend.controlador.dtos;

import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.GenericoDAO;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class GenericDTOController<E,S extends GenericoDAO<E>> {
    protected final S service;
    protected final String nombre_entidad;

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
