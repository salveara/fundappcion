package com.fundappcion.controller;

import com.fundappcion.config.RequestError;
import com.fundappcion.entity.ApadrinamientoMascota;;
import com.fundappcion.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/apadrinaMacota")
public class ApadrinamientoMascotaController {
    
    @Autowired
    MascotaService service;

    @PostMapping(consumes = "Application/json")
    public ResponseEntity<ApadrinamientoMascota> saveFoundation(@RequestBody ApadrinamientoMascota apadrinaMacota) {
        RequestError requestError;
        if (service.checkNotNulleableFields(apadrinaMacota)) {
                return new ResponseEntity<ApadrinamientoMascota>(service.saveApadrinaMascota(apadrinaMacota), HttpStatus.OK);
        } else {
            requestError = new RequestError("Mala peticiÃ³n", "Campos obligatorios no enviados");
        }
        return new ResponseEntity(requestError.toString(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<ApadrinamientoMascota> getFountationsByNit(@ModelAttribute("codigo") String codigo) {
        if (service.stringNotNullOrNotEmpty(codigo)) {
            ApadrinamientoMascota apadrinaMacota = service.getApadrinaMascotaByCodigo(codigo);
            if (apadrinaMacota != null) {
                return new ResponseEntity<ApadrinamientoMascota>(service.getApadrinaMascotaByCodigo(codigo), HttpStatus.OK);
            }
        }
        return new ResponseEntity(new RequestError("Mala peticiÃ³n", "El apadrinamiento con el codigo dado no existe").toString(), 
                HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ApadrinamientoMascota>> getFountations(@RequestParam(name = "mascota", required = false) String mascota,
                                                          @RequestParam(name = "conexion", required = false) String conexion) {
        return new ResponseEntity<List<ApadrinamientoMascota>>(service.getApadrinaMascotaFromParams(mascota, conexion), HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> deleteApadrinaMacota(@ModelAttribute("codigo") String codigo) {
        if (service.apadrinaMascotaExist(codigo)) {
            return new ResponseEntity<String>(service.deleteApadrinaMascota(codigo).getCodigo(), HttpStatus.OK);
        }
        return new ResponseEntity(new RequestError("Mala peticion", "El apadrinamiento con el codigo dado no existe").toString(), 
                HttpStatus.BAD_REQUEST);
    }
}
