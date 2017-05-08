package com.fundappcion.controller;

import com.fundappcion.entity.Fundacion;
import com.fundappcion.entity.dto.FundacionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/fundaciones")
public class FundacionController {

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Fundacion> getFoundation(@RequestBody FundacionDto fundacionDto) {

        return null;
    }
}
