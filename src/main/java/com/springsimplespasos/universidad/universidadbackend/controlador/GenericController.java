package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.GenericoDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

public class GenericController <E, S extends GenericoDAO<E>> {

    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<E>> obtenerTodos(){
        List<E> listado = (List<E>) service.findAll();
        if(listado.isEmpty()) {
            throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
        }
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<E> obtenerPorID(@PathVariable(value = "id") Integer id){
        Optional<E> oEntidad = service.findById(id);
        if(!oEntidad.isPresent()) {
            throw new BadRequestException(String.format("%s con id %d no existe", nombreEntidad, id));
        }
        return new ResponseEntity<>(oEntidad.get(), HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<E> borrarPorID(@PathVariable(value = "id") Integer id){
        Optional<E> oEntidad = service.findById(id);
        if(!oEntidad.isPresent()) {
            throw new BadRequestException(String.format("%s con id %d no existe", nombreEntidad, id));
        }
        service.deleteById(id);
        return new ResponseEntity<>(oEntidad.get(), HttpStatus.OK);
    }
    @PostMapping(value = "/persist")
    public ResponseEntity<E> altaEntidad(E entidad){
        try {
            E entidadPersistida = service.save(entidad);
            return new ResponseEntity<>(entidadPersistida, HttpStatus.OK);
        } catch (Exception e) {
            throw new BadRequestException(String.format("No se ha podido guardar el %s", nombreEntidad));
        } finally {
            System.out.println("Se ha guardado el " + nombreEntidad);
        }
    }
}
