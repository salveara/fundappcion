package com.fundappcion.config;

import com.fundappcion.entity.Fundacion;
import com.fundappcion.repository.FundacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SetUp {

    @Autowired
    FundacionRepository repository;

    @PostConstruct
    public void createData() {
        repository.save(new Fundacion("0321565486","Gorditos de corazon",
                "Fundacion que ayuda a personas con sobrepeso", "gorditos@gmail.com",
                "www.gorditos.com", "Medellin", "cll 45c 34 # 56", "3255698"));
        repository.save(new Fundacion("2311565486","Gorditos de corazon",
                "Fundacion que ayuda a personas con sobrepeso", "gorditos@gmail.com",
                "www.gorditos.com", "Bogota", "cll 46589#213", "54213545"));
        repository.save(new Fundacion("321516486","Teleton",
                "Evento publico para recoger donaciones", "releton@gmail.com",
                "www.teleton.com", "Medellin", "cll 54e #5422", "12354587"));
    }
}
