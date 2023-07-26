package com.springsimplespasos.universidad.universidadbackend.repositorios;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Qualifier("repositorioAlumnos")
@Repository
public interface AlumnoRepository extends PersonaRepository {

    @Query("select a from Alumno a join fetch a.carrera c where c.nombre = ?1")
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
//    @Query("select a from Alumno a join fetch a.carrera c where c.nombre = ?1")
//    Iterable<Persona> allAlumnos(String nombre);

}
