package com.sonemma.com.springjpa.Services;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customers {

    @Id
    @GeneratedValue //auto increment
    private Integer cid;

    private String first_name;
    private String last_name;
    private String phone_number;
    private String state;
    private String zipe_code;
    private String country;
    private String email;

    public Customers(){

    }

    public Customers(String first_name, String last_name, String phone_number, String state, String zipe_code, String country, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.state = state;
        this.zipe_code = zipe_code;
        this.country = country;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipe_code() {
        return zipe_code;
    }

    public void setZipe_code(String zipe_code) {
        this.zipe_code = zipe_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
