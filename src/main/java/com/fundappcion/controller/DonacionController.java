package com.fundappcion.controller;

import com.fundappcion.entity.Donacion;
import com.fundappcion.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/donaciones")
public class DonacionController {

    @Autowired
    DonacionService service;

    @PostMapping(consumes = "Application/json")
    public ResponseEntity<Donacion> saveDonacions(@RequestBody Donacion donacion) {
        return new ResponseEntity<Donacion>(service.saveDonacion(donacion), HttpStatus.OK);
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<Donacion> getDonationsByCode(@ModelAttribute("codigo") String code) {
        return new ResponseEntity<Donacion>(service.getDonationByCode(code), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Donacion>> getDonations(@RequestParam(name = "donante", required = false) String donante,
                                                       @RequestParam(name = "fundacion", required = false) String fundacion) {
        return new ResponseEntity<List<Donacion>>(service.getDonationsFromParams(donante, fundacion), HttpStatus.OK);
    }

}
