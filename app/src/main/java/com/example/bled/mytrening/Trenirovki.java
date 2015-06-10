package com.example.bled.mytrening;

import java.sql.Time;
import java.util.Date;

public class Trenirovki {

    private Integer id_trenirovka;
    private Integer id_programma;
    private Integer id_den_programmi;
    private Date data_trenirovki;
    private Time vremja_vipolnenija;

    Trenirovki(){}

    public Trenirovki(Integer id_trenirovka,Integer id_programma, Integer id_den_programmi, Date data_trenirovki, Time vremja_vipolnenija){
        this.id_trenirovka = id_trenirovka;
        this.id_programma = id_programma;
        this.id_den_programmi = id_den_programmi;
        this.data_trenirovki = data_trenirovki;
        this.vremja_vipolnenija = vremja_vipolnenija;
    }
    public Integer getId_trenirovka() {
        return id_trenirovka;
    }

    public void setId_trenirovka(Integer id_trenirovka) {
        this.id_trenirovka = id_trenirovka;
    }

    public Integer getId_programma(){

        return id_programma;
    }

    public void setId_programma(Integer id_programma){

        this.id_programma = id_programma;
    }

    public Integer getId_den_programmi() {
        return id_den_programmi;
    }

    public void setId_den_programmi(Integer id_den_programmi) {
        this.id_den_programmi = id_den_programmi;
    }

    public Date getData_trenirovki(){
        return data_trenirovki;
    }

    public void setData_trenirovki(Date data_trenirovki){
        this.data_trenirovki = data_trenirovki;
    }

    public Time getVremja_vipolnenija(){
        return vremja_vipolnenija;
    }

    public void setVremja_vipolnenija(Time vremja_vipolnenija){
        this.vremja_vipolnenija = vremja_vipolnenija;
    }
}
