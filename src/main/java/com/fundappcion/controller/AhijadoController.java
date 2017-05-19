package com.fundappcion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fundappcion.config.RequestError;
import com.fundappcion.entity.Ahijado;
import com.fundappcion.service.AhijadoService;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("/api/v1/apadrinamiento/personas")
public class AhijadoController {

    @Autowired
    AhijadoService service;
    
    @PostMapping(consumes = "Application/json")
    public ResponseEntity<Ahijado> saveAhijados(@RequestBody Ahijado ahijado) {
        RequestError requestError;
        if (service.checkNotNulleableFields(ahijado)) {
            if (!service.ahijadoExist(ahijado.getId())) {
                return new ResponseEntity<Ahijado>(service.saveAhijado(ahijado), HttpStatus.OK);
            } else {
                requestError = new RequestError("Mala petición", "El ahijado con el id dado ya existe");
            }
        } else {
            requestError = new RequestError("Mala petición", "Campos obligatorios no enviados");
        }
        return new ResponseEntity(requestError.toString(), HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Ahijado> getAhijadoById(@ModelAttribute("id") String id) {
        if (service.stringNotNullOrNotEmpty(id)) {
            Ahijado ahijado = service.getAhijadoById(id);
            if (ahijado != null) {
                return new ResponseEntity<Ahijado>(service.getAhijadoById(id), HttpStatus.OK);
            }
        }
        return new ResponseEntity(new RequestError("Mala petición", "El ahijado con el id dado dado no existe").toString(), HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping()
    public ResponseEntity<List<Ahijado>> getAhijados(@RequestParam(name = "ciudad", required = false) String ciudad,
                                                       @RequestParam(name = "fundacion", required = false) String fundacion) {
        return new ResponseEntity<List<Ahijado>>(service.getAhijadosFromParams(ciudad, fundacion), HttpStatus.OK);
    }
    
    @PutMapping(consumes = "Application/json")
    public ResponseEntity<Ahijado> updateAhijado(@RequestBody Ahijado updatedAhijado) {
        RequestError requestError;
        if (service.checkNotNulleableFields(updatedAhijado)) {
            if (service.ahijadoExist(updatedAhijado.getId())) {
                return new ResponseEntity<Ahijado>(service.saveAhijado(updatedAhijado), HttpStatus.OK);
            } else {
                requestError = new RequestError("Mala petición", "El ahijado con el id dado no existe");
            }
        } else {
            requestError = new RequestError("Mala petición", "Campos obligatorios no enviados");
        }
        return new ResponseEntity(requestError.toString(), HttpStatus.BAD_REQUEST);
    }
}
