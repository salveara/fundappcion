package com.fundappcion.config;

import com.fundappcion.entity.Donacion;
import com.fundappcion.entity.Fundacion;
import com.fundappcion.repository.DonacionRepository;
import com.fundappcion.repository.FundacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class SetUp {

    @Autowired
    FundacionRepository fundacionRepository;

    @Autowired
    DonacionRepository donacionRepository;

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
    }
}
