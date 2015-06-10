package com.example.bled.mytrening;

public class Upragnenija {

    private Integer id_upragnenie;
    private String nazvanie;

    Upragnenija(){}

    public Upragnenija(Integer id_upragnenie, String nazvanie){
        this.id_upragnenie = id_upragnenie;
        this.nazvanie = nazvanie;
    }

    public Integer getId_upragnenie(){
        return id_upragnenie;
    }

    public void setId_upragnenie(Integer id_upragnenie){
        this.id_upragnenie = id_upragnenie;
    }

    public String getNazvanie(){
        return nazvanie;
    }

    public void setNazvanie(String nazvanie){
        this.nazvanie = nazvanie;
    }
}
