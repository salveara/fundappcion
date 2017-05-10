package com.fundappcion.controller;

import com.fundappcion.entity.Fundacion;
import com.fundappcion.repository.FundacionRepository;
import com.fundappcion.service.FundacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/fundaciones")
public class FundacionController {

    @Autowired
    FundacionRepository repository;

    @Autowired
    FundacionService service;

    @PostMapping(consumes = "Application/json")
    public ResponseEntity<Fundacion> saveFoundation(@RequestBody Fundacion fundacion) {

        return new ResponseEntity<Fundacion>(service.saveFoundation(fundacion), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Fundacion>> getFountations(@RequestParam(name = "codigo", required = false) String code,
                                                          @RequestParam(name = "nombre", required = false) String name,
                                                          @RequestParam(name = "ciudad", required = false) String city) {

        return new ResponseEntity<List<Fundacion>>(service.getFoundationsFromParams(code, name, city), HttpStatus.OK);
    }

    @PutMapping(path = "/{codigo}", consumes = "Application/json")
    public ResponseEntity<Fundacion> updateFoundation(@ModelAttribute("codigo") String code,
                                                      @RequestBody Fundacion fundacionUpdated) {

        fundacionUpdated.setCodigo(code);
        return new ResponseEntity<Fundacion>(service.saveFoundation(fundacionUpdated), HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Fundacion> deleteFoundation(@ModelAttribute("codigo") String code) {

        return new ResponseEntity<Fundacion>(service.deleteFoundation(code), HttpStatus.OK);
    }
}
