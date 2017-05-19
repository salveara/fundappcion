package com.fundappcion.controller;

import com.fundappcion.config.RequestError;
import com.fundappcion.entity.Donacion;
import com.fundappcion.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/donaciones")
public class DonacionController {

    @Autowired
    DonacionService service;

    @PostMapping(consumes = "Application/json")
    public ResponseEntity<Donacion> saveDonacions(@RequestBody Donacion donacion) {
        if (service.checkNotNulleableFields(donacion)) {
            return new ResponseEntity<Donacion>(service.saveDonacion(donacion), HttpStatus.OK);
        }
        RequestError requestError = new RequestError("Mala petición", "Campos obligatorios no enviados");
        return new ResponseEntity(requestError.toString(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<Donacion> getDonationsByCode(@ModelAttribute("codigo") String code) {
        Donacion donacion = service.findByCode(code);
        if (donacion != null) {
            return new ResponseEntity<Donacion>(service.getDonationByCode(code), HttpStatus.OK);
        }
        RequestError requestError = new RequestError("Mala peticion", "La donación con el codigo dado no existe");
        return new ResponseEntity(requestError.toString(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping()
    public ResponseEntity<List<Donacion>> getDonations(@RequestParam(name = "donante", required = false) String donante,
                                                       @RequestParam(name = "fundacion", required = false) String fundacion) {
        return new ResponseEntity<List<Donacion>>(service.getDonationsFromParams(donante, fundacion), HttpStatus.OK);
    }

}
