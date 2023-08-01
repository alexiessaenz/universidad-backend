package com.springsimplespasos.universidad.universidadbackend.controlador.dtos;

import com.springsimplespasos.universidad.universidadbackend.controlador.GenericController;
import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.dtos.PersonaDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Profesor;
import com.springsimplespasos.universidad.universidadbackend.modelo.mappers.mapstructs.AlumnoMapper;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
//@AllArgsConstructor
public class PersonaDTOController extends GenericController<Persona, PersonaDAO> {
    protected final AlumnoMapper alumnoMapper;

    /*public PersonaDTOController(PersonaDAO service, AlumnoMapper alumnoMapper){
        super(service);
    }*/

    /*public PersonaDTOController(PersonaDAO service, String nombreEntidad, AlumnoMapper alumnoMapper) {
        super(service, nombreEntidad);
        this.alumnoMapper = alumnoMapper;

    }*/

    public PersonaDTOController(PersonaDAO service, String nombreEntidad, AlumnoMapper alumnoMapper) {
        super(service, nombreEntidad);
        this.alumnoMapper = alumnoMapper;
    }
    public ResponseEntity<PersonaDTO> altaPersona(Persona persona) {
        ResponseEntity<Persona> personaEntidad = super.altaEntidad(persona);
        PersonaDTO dto = null;
//        if(personaEntidad instanceof Alumno) {
//            dto = alumnoMapper.mapAlumno((Alumno) personaEntidad);
//        } else if (personaEntidad instanceof Profesor) {
//            //aplicariamos mapper de profesor
//        } else if (personaEntidad instanceof Empleado) {
//            //aplicamos el mapper de empelado
//        }
        return null;  //dto;
     }

    public PersonaDTO buscarPersonaPorId(Integer id) {
//        Optional<Persona> oPersona = super.obtenerPorId(id);
//        Persona persona;
//        PersonaDTO dto = null;
//        if(oPersona.isEmpty()){
//            return null;
//        } else {
//            persona = oPersona.get();
//        }
//        if(persona instanceof Alumno) {
//            dto = alumnoMapper.mapAlumno((Alumno) persona);
//        } else if (persona instanceof Profesor) {
//            //aplicariamos mapper de profesor
//        } else if (persona instanceof Empleado) {
//            //aplicamos el mapper de empelado
//        }
        return null; //dto;
    }
}