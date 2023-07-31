package com.springsimplespasos.universidad.universidadbackend.controlador.dtos;

import com.springsimplespasos.universidad.universidadbackend.controlador.GenericController;
import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.dtos.PersonaDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.modelo.mappers.mapstructs.AlumnoMapper;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class PersonaDTOController extends GenericController<Persona, PersonaDAO> {
    protected final AlumnoMapper alumnoMapper;

    public PersonaDTOController(PersonaDAO service, AlumnoMapper alumnoMapper){
        super(service);
    }

    public PersonaDTOController(PersonaDAO service, String nombreEntidad, AlumnoMapper alumnoMapper) {
        super(service, nombreEntidad);
        this.alumnoMapper = alumnoMapper;

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

    public PersonaDTO buscarPersonaPorId(Integer id) {
        Optional<Persona> oPersona = super.obtenerPorId(id);
        Persona persona;
        if (oPersona.isEmpty()) {
            return null;
        } else {
            persona = oPersona.get();
        }

        if (persona instanceof Alumno) {
            dto = alumnoMapper.mapAlumno((Alumno) persona);
        } else if (personaEntidad intanceof Profesor) {
            // TODO: 31/7/2023 mapear profesor
        } else if (personaEntidad intanceof Empleado) {
            // TODO: 31/7/2023 mapear empleado
        }
        return dto;
    }

    public PersonaDTO altaPErsona(Persona persona){
        Persona personaEntidad = super.altaEntidad(persona);
        PersonaDTO dto = null;
        if (personaEntidad instanceof Alumno) {
            dto = alumnoMapper.mapAlumno((Alumno) personaEntidad);
        } else if (personaEntidad intanceof Profesor) {
            // TODO: 31/7/2023 mapear profesor
        } if (personaEntidad intanceof Empleado) {
            // TODO: 31/7/2023 mapear empleado
        }

    }
}
