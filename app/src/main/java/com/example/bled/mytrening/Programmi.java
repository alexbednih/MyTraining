package com.example.bled.mytrening;


public class Programmi {

    private Integer id_programma;
    private String nazvanie;

    Programmi(){}

    public Programmi(Integer id_programma, String nazvanie){
        this.id_programma = id_programma;
        this.nazvanie = nazvanie;
    }

    public Integer getId_programma(){

        return id_programma;
    }

    public void setId_programma(Integer id_programma){

        this.id_programma = id_programma;
    }

    public String getNazvanie(){

        return nazvanie;
    }

    public void setNazvanie(String nazvanie){
        this.nazvanie = nazvanie;
    }
}
