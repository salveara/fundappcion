package com.fundappcion.entity;

import org.springframework.stereotype.Repository;

@Repository

public class Fundacion {

    private String code;
    private String name;
    private String description;
    private String email;
    private String page;
    private String city;
    private String address;
    private String phone;

    public Fundacion(String name, String description, String email, String page, String city, String address, String phone) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.page = page;
        this.city = city;
        this.address = address;
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
