package com.hb.domain;

public class Vendors {
     private Integer vend_id;
     private String vend_name;
     private String vend_address;
     private String vend_city;
     private String vend_state;
     private String vend_zip;
     private String vend_country;

    public Integer getVend_id() {
        return vend_id;
    }

    public void setVend_id(Integer vend_id) {
        this.vend_id = vend_id;
    }

    public String getVend_name() {
        return vend_name;
    }

    public void setVend_name(String vend_name) {
        this.vend_name = vend_name;
    }

    public String getVend_address() {
        return vend_address;
    }

    public void setVend_address(String vend_address) {
        this.vend_address = vend_address;
    }

    public String getVend_city() {
        return vend_city;
    }

    public void setVend_city(String vend_city) {
        this.vend_city = vend_city;
    }

    public String getVend_state() {
        return vend_state;
    }

    public void setVend_state(String vend_state) {
        this.vend_state = vend_state;
    }

    public String getVend_zip() {
        return vend_zip;
    }

    public void setVend_zip(String vend_zip) {
        this.vend_zip = vend_zip;
    }

    public String getVend_country() {
        return vend_country;
    }

    public void setVend_country(String vend_country) {
        this.vend_country = vend_country;
    }

    @Override
    public String toString() {
        return "Vendors{" +
                "vend_id=" + vend_id +
                ", vend_name='" + vend_name + '\'' +
                ", vend_address='" + vend_address + '\'' +
                ", vend_city='" + vend_city + '\'' +
                ", vend_state='" + vend_state + '\'' +
                ", vend_zip='" + vend_zip + '\'' +
                ", vend_country='" + vend_country + '\'' +
                '}';
    }
}
