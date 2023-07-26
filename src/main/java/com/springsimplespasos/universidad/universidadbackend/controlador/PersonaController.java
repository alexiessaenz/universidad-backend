package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaDAO> {

    public PersonaController(PersonaDAO service){
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public Persona buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if(!oPersona.isPresent()) {
            throw new BadRequestException(String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
        }
        return oPersona.get();
    }
    @GetMapping(value = "persona/{apellido}")
    public ResponseEntity<List<Persona>> buscarPersonaPorApellido(@PathParam("apellido") String apellido){
        List<Persona> listado = (List<Persona>) service.buscarPersonaPorApellido(apellido);
        if(listado.isEmpty())
            throw new BadRequestException(String.format("No se encontro Persona con apellido %s", apellido));
        return ResponseEntity.ok(listado);
    }

    @GetMapping(value = "persona/{dni}")
    public ResponseEntity<Persona> buscarPorDni(@PathParam("dni") String dni){
        Optional<Persona> oPersona = service.buscarPorDni(dni);
        if(!oPersona.isPresent())
            throw new BadRequestException(String.format("No se encontro Persona con dni %s", dni));
        return ResponseEntity.ok(oPersona.get());
    }
}
