package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController extends PersonaController{

    private final CarreraDAO carreraDAO;
    private final ProfesorDAO profesorDAO;

    @Autowired
    public ProfesorController(@Qualifier("profesorDAOImpl") PersonaDAO profesorDao, CarreraDAO carreraDAO) {
        super(profesorDao);
        nombreEntidad = "Profesor";
        this.carreraDAO = carreraDAO;
        this.profesorDAO = (ProfesorDAO) profesorDao;
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Persona>> buscarTodos(){
        List<Persona> listado = (List<Persona>) service.findAll();
        if(listado.isEmpty())
            throw new BadRequestException(String.format("No se encontro %s", nombreEntidad));
        return ResponseEntity.ok(listado);
    }
    @GetMapping(value = "/carrera/{nombre}")
    public ResponseEntity<List<Persona>> buscarProfesoresPorNombreCarrera(@PathVariable String nombre){
        List<Persona> listado = (List<Persona>) profesorDAO.buscarProfesoresPorNombreCarrera(nombre);
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
    public Persona actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno = service.findById(id);
        if(!oAlumno.isPresent()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", id));
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return service.save(alumnoUpdate);
    }

  /*  @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoDao.deleteById(id);
    }*/

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = service.findById(idAlumno);
        if(!oAlumno.isPresent()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", idAlumno));
        }

        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("Carrera con id %d no existe", idCarrera));
        }

        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();

        ((Alumno)alumno).setCarrera(carrera);

        return service.save(alumno);
    }
}
