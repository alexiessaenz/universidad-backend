package com.springsimplespasos.universidad.universidadbackend.comandos;

import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Component
@Order(1)
public class ProfesorCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("ProfesorDAOImpl")
    private PersonaDAO personaDao;

    @Qualifier("CarreraDAOImpl")
    @Autowired
    private CarreraDAO carreraDao;

    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("----------------- Profesores Command -----------------");
        System.out.println("--------- Busqueda de Profesores por Carrera ---------");
        Iterable<Profesor> iProfesores = ((ProfesorDao)personaDao).findProfesoresByCarrera
                (ObjetosDummy.getCarreraIngSis().getNombre());
        iProfesores.forEach(System.out::println);

        for (Profesor profesor : iProfesores) {
            Set<Carrera> carrerasAsignadas = new HashSet<>();

            for (Carrera carrera : carrerasAsignadas) {
                carrerasAsignadas.add(carrera);
            }
            profesor.setCarreras(carrerasAsignadas);
        }*/
    }
}
