package com.springsimplespasos.universidad.universidadbackend;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Profesor;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class UniversidadBackendApplication {

	@Autowired
	private AlumnoDAO service;

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();
		/*for(String str : beanDefinitionNames){
			System.out.println(str);
		}*/
	}

	@Bean
	public CommandLineRunner runner(){
		return args -> {
			Direccion direccion = new Direccion
					("Calle Circunvalacion", "123", "4567", "", "", "San Salvador");
			Persona alumno = new Alumno(null, "Frank", "Lopez", "0123456789", direccion);
			Persona save = service.save(alumno);
			System.out.println(save.toString());
		};
	}
}
