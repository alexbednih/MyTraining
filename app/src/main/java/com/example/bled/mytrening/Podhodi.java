package com.example.bled.mytrening;


import java.sql.Time;

public class Podhodi {

    private Integer id_podhod;
    private Integer id_upragnenie;
    private Integer id_trenirovka;
    private Integer kol_povtoren;
    private Time vremja_vipolnenija;

    Podhodi(){}

    public Podhodi(Integer id_podhod, Integer id_upragnenie, Integer id_trenirovka, Integer kol_povtoren, Time vremja_vipolnenija){
        this.id_podhod = id_podhod;
        this.id_upragnenie = id_upragnenie;
        this.id_trenirovka = id_trenirovka;
        this.kol_povtoren = kol_povtoren;
        this.vremja_vipolnenija = vremja_vipolnenija;
    }

    public Integer getId_podhod(){
        return id_podhod;
    }

    public void setId_podhod(Integer id_podhod){
        this.id_podhod = id_podhod;
    }

    public Integer getId_upragnenie(){
        return id_upragnenie;
    }

    public void setId_upragnenie(Integer id_upragnenie){
        this.id_upragnenie = id_upragnenie;
    }

    public Integer getId_trenirovka() {
        return id_trenirovka;
    }

    public void setId_trenirovka(Integer id_trenirovka) {
        this.id_trenirovka = id_trenirovka;
    }

    public Integer getKol_povtoren(){
        return kol_povtoren;
    }

    public void setKol_povtoren(Integer kol_povtoren){
        this.kol_povtoren = kol_povtoren;
    }

    public Time getVremja_vipolnenija(){
        return vremja_vipolnenija;
    }

    public void setVremja_vipolnenija(Time vremja_vipolnenija){
        this.vremja_vipolnenija = vremja_vipolnenija;
    }
}
