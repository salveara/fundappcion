package com.fundappcion.service;

import org.springframework.stereotype.Service;

@Service
public class FundacionService {

    public boolean stringNotNullOrEmpty(String field) {
        return field != null || "".equals(field);
    }

}
