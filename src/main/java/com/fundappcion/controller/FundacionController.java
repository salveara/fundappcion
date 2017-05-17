package com.fundappcion.controller;

import com.fundappcion.config.RequestError;
import com.fundappcion.entity.Fundacion;
import com.fundappcion.repository.FundacionRepository;
import com.fundappcion.service.FundacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/fundaciones")
public class FundacionController {
    
    @Autowired
    FundacionService service;

    @PostMapping(consumes = "Application/json")
    public ResponseEntity<Fundacion> saveFoundation(@RequestBody Fundacion fundacion) {
        RequestError requestError;
        if (service.checkNotNulleableFields(fundacion)) {
            if (!service.foundationExist(fundacion.getNit())) {
                return new ResponseEntity<Fundacion>(service.saveFoundation(fundacion), HttpStatus.OK);
            } else {
                requestError = new RequestError("Mala petición", "La fundación con el nit dado ya existe");
            }
        } else {
            requestError = new RequestError("Mala petición", "Campos obligatorios no enviados");
        }
        return new ResponseEntity(requestError.toString(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{nit}")
    public ResponseEntity<Fundacion> getFountationsByNit(@ModelAttribute("nit") String nit) {
        if (service.stringNotNullOrNotEmpty(nit)) {
            Fundacion fundacion = service.getFoundationsFromNit(nit);
            if (fundacion != null) {
                return new ResponseEntity<Fundacion>(service.getFoundationsFromNit(nit), HttpStatus.OK);
            }
        }
        return new ResponseEntity(new RequestError("Mala petición", "La fundación con el nit dado no existe").toString(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Fundacion>> getFountations(@RequestParam(name = "nombre", required = false) String name,
                                                          @RequestParam(name = "ciudad", required = false) String city) {
        return new ResponseEntity<List<Fundacion>>(service.getFoundationsFromParams(name, city), HttpStatus.OK);
    }

    @PutMapping(consumes = "Application/json")
    public ResponseEntity<Fundacion> updateFoundation(@RequestBody Fundacion updatedFoundation) {
        RequestError requestError;
        if (service.checkNotNulleableFields(updatedFoundation)) {
            if (service.foundationExist(updatedFoundation.getNit())) {
                return new ResponseEntity<Fundacion>(service.saveFoundation(updatedFoundation), HttpStatus.OK);
            } else {
                requestError = new RequestError("Mala petición", "La fundación con el nit dado no existe");
            }
        } else {
            requestError = new RequestError("Mala petición", "Campos obligatorios no enviados");
        }
        return new ResponseEntity(requestError.toString(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<String> deleteFoundation(@ModelAttribute("nit") String nit) {
        if (service.foundationExist(nit)) {
            return new ResponseEntity<String>(service.deleteFoundation(nit).getNombre(), HttpStatus.OK);
        }
        return new ResponseEntity(new RequestError("Mala peticion", "La fundación con el nit dado no existe").toString(), HttpStatus.BAD_REQUEST);
    }
}
