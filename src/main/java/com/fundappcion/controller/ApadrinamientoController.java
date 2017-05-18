package com.fundappcion.controller;

import com.fundappcion.config.RequestError;
import com.fundappcion.entity.ApadrinamientoPersona;
import com.fundappcion.entity.Fundacion;
import com.fundappcion.repository.FundacionRepository;
import com.fundappcion.service.ApadrinamientoService;
import com.fundappcion.service.FundacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/apadrinamiento")
public class ApadrinamientoController {
    
    @Autowired
    ApadrinamientoService service;

    @PostMapping(consumes = "Application/json")
    public ResponseEntity<ApadrinamientoPersona> saveFoundation(@RequestBody ApadrinamientoPersona apadrinamiento) {
        RequestError requestError;
        if (service.checkNotNulleableFields(apadrinamiento)) {
                return new ResponseEntity<ApadrinamientoPersona>(service.saveApadrinamiento(apadrinamiento), HttpStatus.OK);
        } else {
            requestError = new RequestError("Mala petición", "Campos obligatorios no enviados");
        }
        return new ResponseEntity(requestError.toString(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<ApadrinamientoPersona> getFountationsByNit(@ModelAttribute("codigo") String codigo) {
        if (service.stringNotNullOrNotEmpty(codigo)) {
            ApadrinamientoPersona apadrinamiento = service.getApadrinamientoByCodigo(codigo);
            if (apadrinamiento != null) {
                return new ResponseEntity<ApadrinamientoPersona>(service.getApadrinamientoByCodigo(codigo), HttpStatus.OK);
            }
        }
        return new ResponseEntity(new RequestError("Mala petición", "El apadrinamiento con el codigo dado no existe").toString(), 
                HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ApadrinamientoPersona>> getFountations(@RequestParam(name = "ahijado", required = false) String ahijado,
                                                          @RequestParam(name = "padrino", required = false) String padrino) {
        return new ResponseEntity<List<ApadrinamientoPersona>>(service.getApadrinamientosFromParams(ahijado, padrino), HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> deleteApadrinamiento(@ModelAttribute("codigo") String codigo) {
        if (service.apadrinamientoExist(codigo)) {
            return new ResponseEntity<String>(service.deleteApadrinamiento(codigo).getCodigo(), HttpStatus.OK);
        }
        return new ResponseEntity(new RequestError("Mala peticion", "El apadrinamiento con el codigo dado no existe").toString(), 
                HttpStatus.BAD_REQUEST);
    }
}
