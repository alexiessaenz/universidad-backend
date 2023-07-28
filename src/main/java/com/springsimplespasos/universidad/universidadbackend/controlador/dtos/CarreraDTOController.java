package com.springsimplespasos.universidad.universidadbackend.controlador.dtos;

import com.springsimplespasos.universidad.universidadbackend.modelo.dtos.CarreraDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.mappers.CarreraMapper;
import com.springsimplespasos.universidad.universidadbackend.modelo.mappers.mapstructs.CarreraMapperMS;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/carreras")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class CarreraDTOController {
    @Autowired
    private CarreraDAO carreraDAO;
    @Autowired
    private CarreraMapperMS mapper;
    @GetMapping(value = "")
    public ResponseEntity<?> obtenerTodos(){
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();

        Map<String,Object> mensaje = new HashMap<>();
        List<CarreraDTO> carreraDTOS = carreras
                .stream()
                .map(mapper::mapCarrera)
                .collect(Collectors.toList());

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", carreraDTOS);

        return ResponseEntity.ok(mensaje);
    }
}
