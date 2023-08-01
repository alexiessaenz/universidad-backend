package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
@Deprecated
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class AlumnoController extends PersonaController{

    private final CarreraDAO carreraDAO;
    private final AlumnoDAO alumnoDAO;

    @Autowired
    public AlumnoController(@Qualifier("AlumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
        super(alumnoDao,"entidad");
        nombreEntidad = "Alumno";
        this.carreraDAO = carreraDAO;
        this.alumnoDAO = (AlumnoDAO) alumnoDao;
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Persona>> buscarTodos(){
        List<Persona> listado = (List<Persona>) alumnoDAO.findAll();
        if(listado.isEmpty())
            throw new BadRequestException(String.format("No se encontro %s", nombreEntidad));
        return ResponseEntity.ok(listado);
    }
    /*@GetMapping
    public List<Persona> obtenerTodos(){
        List<Persona> alumnos = (List<Persona>) alumnoDao.findAll();
        if(alumnos.isEmpty()){
            throw new BadRequestException("No existe alumnos");
        }
        return alumnos;
    }

    @GetMapping("/{id}")
    public Persona obtenerAlumnoPorId(@PathVariable(required = false) Integer id){
        Optional<Persona> oAlumno = alumnoDao.findById(id);
        if(!oAlumno.isPresent()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", id));
        }
        return oAlumno.get();
    }

    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return alumnoDao.save(alumno);
    }
*/
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Map<String,Object> mensaje = new HashMap<>();
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno = service.findById(id);
        if(!oAlumno.isPresent()) {
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Alumno con id %d no existe", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());

        mensaje.put("datos",service.save(alumnoUpdate));
        mensaje.put("success",Boolean.TRUE);
        return ResponseEntity.ok(mensaje);
    }

  /*  @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoDao.deleteById(id);
    }*/

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Map<String,Object> mensaje = new HashMap();
        Optional<Persona> oAlumno = service.findById(idAlumno);
        if(!oAlumno.isPresent()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", idAlumno));
        }

        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if(!oCarrera.isPresent()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Carrera con id %d no existe", idCarrera));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();

        ((Alumno)alumno).setCarrera(carrera);

        mensaje.put("datos",service.save(alumno));
        mensaje.put("success",Boolean.TRUE);
        return ResponseEntity.ok(mensaje);
    }
}
