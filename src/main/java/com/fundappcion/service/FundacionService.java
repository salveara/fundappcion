package com.fundappcion.service;

import com.fundappcion.entity.Fundacion;
import com.fundappcion.entity.dto.FundacionDto;
import org.springframework.stereotype.Service;

@Service
public class FundacionService {

    public boolean stringNotNullOrEmpty(String field) {
        return field != null || "".equals(field);
    }

    public Fundacion transformDto(FundacionDto fundacionDto) {
        return new Fundacion(fundacionDto.getNombre(), fundacionDto.getDescripcion(), fundacionDto.getCorreo(),
                fundacionDto.getPagina(), fundacionDto.getCiudad(), fundacionDto.getDireccion(), fundacionDto.getTelefono());
    }

    public Fundacion updateFundation(FundacionDto fundacionDto, Fundacion fundacion) {
        fundacion.setNombre(fundacionDto.getNombre());
        fundacion.setDescripcion(fundacionDto.getDescripcion());
        fundacion.setCorreo(fundacionDto.getCorreo());
        fundacion.setPagina(fundacionDto.getPagina());
        fundacion.setCiudad(fundacionDto.getCiudad());
        fundacion.setDireccion(fundacionDto.getDireccion());
        fundacion.setTelefono(fundacionDto.getTelefono());
        return fundacion;
    }
}
