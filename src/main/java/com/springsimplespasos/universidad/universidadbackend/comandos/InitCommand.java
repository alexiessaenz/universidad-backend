package com.springsimplespasos.universidad.universidadbackend.comandos;

import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitCommand implements CommandLineRunner {

    @Autowired
    @Qualifier(value = "AlumnoDAOImpl")
    private PersonaDAO servicioAlumno;

    /*@Autowired
    @Qualifier(value = "empleadoDaoImpl")
    private PersonaDao servicioEmpleado;*/

    @Autowired
    @Qualifier(value = "AlumnoDAOImpl")
    private PersonaDAO servicioProfesor;

    /*@Autowired
    private AulaDao servicioAula;

    @Autowired
    private PabellonDao servicioPabellon;

    @Autowired
    private CarreraDao servicioCarrera;*/

    @Override
    public void run(String... args) throws Exception {

    }
}
