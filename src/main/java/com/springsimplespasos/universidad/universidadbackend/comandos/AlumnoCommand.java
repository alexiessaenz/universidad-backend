package com.springsimplespasos.universidad.universidadbackend.comandos;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.swing.text.html.Option;
import java.util.Optional;


@Component
@Order(1)
public class AlumnoCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDao;

    @Autowired
    private CarreraDAO carreraDao;

    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("----------------- ALumnos Command -----------------");
        System.out.println("----------------- Busqueda de Personas por Apellido -----------------");
        Iterable<Persona> iPersona = personaDao.buscarPersonaPorApellido(ObjetosDummy.getAlumnoDos().getApellido());
        iPersona.forEach(System.out::println);

        System.out.println("----------------- Busqueda de Personas por DUI -----------------");
        Optional<Persona> oPersona = personaDao.buscarPorDui(ObjetosDummy.getEmpleadoUno().getDui());
        if (oPersona.isPresent()){
            System.out.println(oPersona.get().toString());
        }
        System.out.println("--------- Busqueda de Personas por Nombre y Apellido ---------");
        Optional<Persona> oPersonaDos = personaDao.buscarPorNombreYApellido(ObjetosDummy.getProfesorDos().getNombre(),
                ObjetosDummy.getProfesorDos().getApellido());
        if (oPersona.isPresent()){
            System.out.println(oPersonaDos.get().toString());
        }
        System.out.println("--------- Busqueda de Alumnos por Carrera ---------");
        Iterable<Persona> iAlumnos= ((AlumnoDao)personaDao).buscarAlumnosPorNombreCarrera
                (ObjetosDummy.getCarreraIngSis().getNombre());
        iAlumnos.forEach(System.out::println);*/
    }
}
