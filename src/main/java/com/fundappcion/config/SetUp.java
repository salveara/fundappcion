package com.fundappcion.config;

import com.fundappcion.entity.Ahijado;
import com.fundappcion.entity.ApadrinamientoPersona;
import com.fundappcion.entity.Donacion;
import com.fundappcion.entity.Fundacion;
import com.fundappcion.repository.AhijadoRepository;
import com.fundappcion.repository.ApadrinamientoPersonaRepository;
import com.fundappcion.repository.DonacionRepository;
import com.fundappcion.repository.FundacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SetUp {

    @Autowired
    FundacionRepository fundacionRepository;

    @Autowired
    DonacionRepository donacionRepository;
    
    @Autowired
    AhijadoRepository ahijadoRepository;
    
    @Autowired
    ApadrinamientoPersonaRepository apadrinamientoPersonaRepository;

    @PostConstruct
    public void createData() {
        fundacionRepository.save(new Fundacion("0321565486","Gorditos de corazon",
                "Fundacion que ayuda a personas con sobrepeso", "gorditos@gmail.com",
                "www.gorditos.com", "Medellin", "cll 45c 34 # 56", "3255698"));
        fundacionRepository.save(new Fundacion("2311565486","Gorditos de corazon",
                "Fundacion que ayuda a personas con sobrepeso", "gorditos@gmail.com",
                "www.gorditos.com", "Bogota", "cll 46589#213", "54213545"));
        fundacionRepository.save(new Fundacion("321516486","Teleton",
                "Evento publico para recoger donaciones", "releton@gmail.com",
                "www.teleton.com", "Medellin", "cll 54e #5422", "12354587"));
        
        donacionRepository.save(new Donacion("12354-54", "54631-5846", new Date(),
                "Televisor muy bueno", 1, "www.imagen.com", "valido"));
        donacionRepository.save(new Donacion("gdhf54-54", "fhdg31-5846", new Date(),
                "Radio muy bueno", 2, "www.radio.com", "valido"));
        
        ahijadoRepository.save(new Ahijado("2342434", "tarjeda de identidad", "Robbie Reyes", new Date(), "colombiana", "Medellin", "0321565486",
                "Calle siempre viva #43-50", "3245454", "huerfano"));
        ahijadoRepository.save(new Ahijado("9879798", "tarjeda de identidad", "Ramon Gomez", new Date(), "colombiana", "Barranquilla", "0321565486",
                "Calle siempre viva #43-50", "3245454", "discapacitado"));
        
        apadrinamientoPersonaRepository.save(new ApadrinamientoPersona("2342434", "7868678787", new Date(), new Date(), "ropa"));
        apadrinamientoPersonaRepository.save(new ApadrinamientoPersona("9879798", "7978979979", new Date(), new Date(), "juguetes"));
    }
}
